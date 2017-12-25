package com.company.XMLparsers.parsers;

import java.io.IOException;

public class InvalidDataException extends IOException {

    public InvalidDataException(){
        super();
    }

    public InvalidDataException(String s){
        super(s);
    }
}
