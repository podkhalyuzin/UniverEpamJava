package com.company.Task4_16_11_17.Deposit;

public class DepositCost implements Printable,Comparable{

    /**
     * in percent, e.g. 18.5%
     */
    private double rate;
    private PaymentFrequency interestPayment;

    public DepositCost(double rate, PaymentFrequency interestPayment) {
        this.rate = rate;
        this.interestPayment = interestPayment;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public PaymentFrequency getInterestPayment() {
        return interestPayment;
    }

    public void setInterestPayment(PaymentFrequency interestPayment) {
        this.interestPayment = interestPayment;
    }
    /**
     * метод считает прибыль за период времени
     * @param money колличество вложеных денег
     * @param months колличество месяцев
     * @return прибыль. Показывает доступную сумму , а не прирост
     */
    public double calculateProfit(int money, int months){
        if(PaymentFrequency.MONTH.equals(this.interestPayment)) {
            for (int i = 0; i < months; i++)
                money += money * (rate / 100);
            return money;
        }
        int years = months/12;
        for (int i = 0; i < years; i++)
            money+= money * (rate / 100);
        return money;
    }

    public void printAsTable(){
        System.out.println("Rate : "+ rate+"%");
        System.out.println("Payment frequency : A "+ interestPayment);
    }

    @Override
    public int compareTo(Object other) {
        DepositCost otherObject = (DepositCost) other;
        double thisProfit = this.calculateProfit(1000,12);
        double otherProfit = otherObject.calculateProfit(1000,12);
        if((thisProfit-otherProfit)>1)
            return 1;
        if((otherProfit-thisProfit)>1)
            return -1;
        return 0;
    }
}
