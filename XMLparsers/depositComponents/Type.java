package com.company.XMLparsers.depositComponents;

public enum Type {
    IMMIDIATE, POSTERESTANTE, RATED, CUMULATIVE, SAVING, METAL;

    public static Type parseToType(String content){
        if(content.equalsIgnoreCase("IMMIDIATE"))
            return IMMIDIATE;
        if(content.equalsIgnoreCase("POSTERESTANTE"))
            return POSTERESTANTE;
        if(content.equalsIgnoreCase("RATED"))
            return RATED;
        if(content.equalsIgnoreCase("CUMULATIVE"))
            return CUMULATIVE;
        if(content.equalsIgnoreCase("SAVING"))
            return SAVING;
        if(content.equalsIgnoreCase("METAL"))
            return METAL;
        else return null;
    }
}
