package com.company.Task4_16_11_17.Deposit;

public enum PaymentFrequency {
    MONTH,YEAR;

    public static PaymentFrequency parseToPaymentFrequency(String value){
            if("MONTH".equals(value))
            return MONTH;
        return YEAR;
    }
}
