package com.company.Task4_16_11_17.Deposit;

/**
 * class contains only boolean fields
 * class shows abilities of deposit related to current amount of money
 */
public class DepositManagment implements Printable{

    private boolean abilityToReplenish;
    private boolean partlyWithdrawal;
    private boolean conditionsOfEarlyWithdrawal;

    public DepositManagment(boolean abilityToReplenish, boolean partlyWithdrawal, boolean conditionsOfEarlyWithdrawal) {
        this.abilityToReplenish = abilityToReplenish;
        this.partlyWithdrawal = partlyWithdrawal;
        this.conditionsOfEarlyWithdrawal = conditionsOfEarlyWithdrawal;
    }

    public boolean isAbilityToReplenish() {
        return abilityToReplenish;
    }

    public void setAbilityToReplenish(boolean abilityToReplenish) {
        this.abilityToReplenish = abilityToReplenish;
    }

    public boolean isPartlyWithdrawal() {
        return partlyWithdrawal;
    }

    public void setPartlyWithdrawal(boolean partlyWithdrawal) {
        this.partlyWithdrawal = partlyWithdrawal;
    }

    public boolean isEarlyWithdrawal() {
        return conditionsOfEarlyWithdrawal;
    }

    public void setEarlyWithdrawal(boolean conditionsOfEarlyWithdrawal) {
        this.conditionsOfEarlyWithdrawal = conditionsOfEarlyWithdrawal;
    }

    public void printAsTable(){
        System.out.println("Ability to replenish : "+ abilityToReplenish);
        System.out.println("Ability to withdraw a part of deposit : "+ partlyWithdrawal);
        System.out.println("Conditions of early withdrawal  : "+ conditionsOfEarlyWithdrawal);
    }
}
