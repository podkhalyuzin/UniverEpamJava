package com.company.Task4_16_11_17.Deposit;

/**
 * class contains parametrs of deposit
 */
public class DepositParametrs implements Printable{

    private final Currency currency;
    private DepositorsGroup group;
    private int minSum;
    /**
     * minimal term in days
     */
    private int minTerm;

    public DepositParametrs(Currency currency, DepositorsGroup group, int minSum,
                            int minTerm) {
        this.currency = currency;
        this.group = group;
        this.minSum = minSum;
        this.minTerm = minTerm;
    }

    public Currency getCurrency() {
        return currency;
    }

    public DepositorsGroup getGroup() {
        return group;
    }

    public void setGroup(DepositorsGroup group) {
        this.group = group;
    }

    public int getMinSum() {
        return minSum;
    }

    public void setMinSum(int minSum) {
        this.minSum = minSum;
    }

    public int getMinTerm() {
        return minTerm;
    }

    public void setMinTerm(int minTerm) {
        this.minTerm = minTerm;
    }

    public void printAsTable() {
        System.out.println("Currency : "+ currency);
        System.out.println("Group of depositors : "+ group);
        System.out.println("Minimal amount : "+ minSum);
        System.out.println("Minimal duration of deposit : "+ minTerm);
    }
}

