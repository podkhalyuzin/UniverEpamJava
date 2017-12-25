package com.company.Task4_16_11_17.Deposit;

public enum DepositorsGroup {
    INDIVIDUAL,ENTITY;

    public static DepositorsGroup parseToDepositorsGroup(String value){
        if("INDIVIDUAL".equals(value))
            return INDIVIDUAL;
        return ENTITY;
    }
}
