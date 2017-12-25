package com.company.Task4_16_11_17.Deposit;

public enum Currency{
    UAH,USD,EUR;

    public static Currency parseToCurrency(String value){
        if("UAH".equals(value))
            return UAH;
        if("USD".equals(value))
            return USD;
        return EUR;
    }
}
