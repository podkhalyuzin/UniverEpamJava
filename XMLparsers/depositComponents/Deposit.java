package com.company.XMLparsers.depositComponents;

public class Deposit implements Comparable {

    private final String bank;
    private final String country;
    private Type type;
    private String depositor;
    private int id;
    private double amount;
    private double profitability;
    /**
     * months
     */
    private int timeConstraint;

    public Deposit(String bank, String country, Type type, String depositor, int id,
                   double amount, double profitability, int timeConstraint) {
        this.bank = bank;
        this.country = country;
        this.type = type;
        this.depositor = depositor;
        this.id = id;
        this.amount = amount;
        this.profitability = profitability;
        this.timeConstraint = timeConstraint;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstraint() {
        return timeConstraint;
    }

    public void setTimeConstraint(int timeConstraint) {
        this.timeConstraint = timeConstraint;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "bank='" + bank + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", depositor='" + depositor + '\'' +
                ", id=" + id +
                ", amount=" + amount +
                ", profitability=" + profitability +
                ", timeConstraint=" + timeConstraint +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Deposit otherDeposit = (Deposit) o;
        if(this.profitability == otherDeposit.profitability)
            return 0;
        return this.profitability - otherDeposit.profitability >0 ? 1:-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deposit deposit = (Deposit) o;

        if (id != deposit.id) return false;
        if (Double.compare(deposit.amount, amount) != 0) return false;
        if (Double.compare(deposit.profitability, profitability) != 0) return false;
        if (timeConstraint != deposit.timeConstraint) return false;
        if (bank != null ? !bank.equals(deposit.bank) : deposit.bank != null) return false;
        if (country != null ? !country.equals(deposit.country) : deposit.country != null) return false;
        if (type != deposit.type) return false;
        return depositor != null ? depositor.equals(deposit.depositor) : deposit.depositor == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bank != null ? bank.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (depositor != null ? depositor.hashCode() : 0);
        result = 31 * result + id;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(profitability);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + timeConstraint;
        return result;
    }
}
