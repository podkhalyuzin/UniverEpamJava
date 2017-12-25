package com.company.Task4_16_11_17;

import com.company.Task4_16_11_17.Deposit.*;

public class Offer implements Printable,Comparable{

    private final String bank;
    private Deposit deposit;

    public Offer(String bank, Deposit deposit) {
        this.bank = bank;
        this.deposit = deposit;
    }

    public Offer(String bank,String depositName,Currency currency,DepositorsGroup group,int minSum,int minTerm,
                 double rate,PaymentFrequency interestPayment,boolean abilityToReplenish,boolean partlyWithdrawal,
                         boolean conditionsOfEarlyWithdrawal){
                this.bank = bank;
                DepositParametrs Parametrs = new DepositParametrs(currency,group,minSum,minTerm);
                DepositCost Cost = new DepositCost(rate,interestPayment);
                DepositManagment Managment = new DepositManagment(abilityToReplenish,partlyWithdrawal,conditionsOfEarlyWithdrawal);
                deposit = new Deposit(depositName,Parametrs,Cost,Managment);
    }

    public String getBank() {
        return bank;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    @Override
    public int compareTo(Object otherObject) {
        Offer otherOffer = (Offer) otherObject;
        if(this.deposit.compareTo(otherOffer.getDeposit())>0)
            return 1;
        return -1;
    }

    @Override
    public void printAsTable() {
        System.out.println("Bank : "+bank);
        this.deposit.printAsTable();
    }
}
