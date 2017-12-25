package com.company.Task4_16_11_17.Deposit;

public class Deposit implements Comparable,Printable{

    private final String name;
    private DepositParametrs parametrs;
    private DepositCost cost;
    private DepositManagment managment;

    public Deposit(String name, DepositParametrs parametrs, DepositCost cost, DepositManagment managment) {
        this.name = name;
        this.parametrs = parametrs;
        this.cost = cost;
        this.managment = managment;
    }

    public String getName() {
        return name;
    }

    public DepositParametrs getParametrs() {
        return parametrs;
    }

    public void setParametrs(DepositParametrs parametrs) {
        this.parametrs = parametrs;
    }

    public DepositCost getCost() {
        return cost;
    }

    public void setCost(DepositCost Cost) {
        this.cost = cost;
    }

    public DepositManagment getManagment() {
        return managment;
    }

    public void setManagment(DepositManagment Managment) {
        this.managment = managment;
    }

    public void printAsTable(){
        System.out.println("Deposit name : "+ name);
        this.cost.printAsTable();
        this.parametrs.printAsTable();
        this.managment.printAsTable();
    }

    @Override
    public int compareTo(Object o) {
        Deposit otherObject = (Deposit) o;
        if(!parametrs.getCurrency().equals(otherObject.getParametrs().getCurrency()))
            return 0;
        return cost.compareTo(otherObject.getCost());
    }
}
