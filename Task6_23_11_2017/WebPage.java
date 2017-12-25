package com.company.Task6_23_11_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class WebPage {

    private final String HTMLcode;
    private final String URL;

    public WebPage(String URLpath) throws IOException {
        URL = URLpath;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        URL site = new URL(URLpath);
        reader = new BufferedReader(new InputStreamReader(site.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
            reader.close();
        HTMLcode = builder.toString();
    }

    public WebPage(String code,String URLpath){
        URL=URLpath;
        HTMLcode=code;
    }

    public String getURL() {
        return URL;
    }

    public ArrayList<String> findURLaddresses(){
        Matcher matcher = Patterns.WEB_URL.matcher(HTMLcode);
        ArrayList<String> result = new ArrayList<String>();
        while(matcher.find()) {
            result.add(HTMLcode.substring(matcher.start(), matcher.end()).trim());
        }
        return result;
    }

    public Map<String,Integer> getFrequency(){
        Map<String,Integer> frequency = new HashMap<String,Integer>();
        String HTMLcodeWithoutCharacters = HTMLcode.replaceAll("\"|>|<|\\.|,|!|\\?|:|="," ").replaceAll("(\\s)+"," ").trim();
        String[] textAsSingleWords = HTMLcodeWithoutCharacters.split(" ");
        for(String word : textAsSingleWords){
            if(frequency.containsKey(word)){
                frequency.put(word,frequency.get(word)+1);
                continue;
            }
            frequency.put(word,1);
        }
        return frequency;
    }
}
