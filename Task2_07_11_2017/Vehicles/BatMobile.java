package com.company.Task2_07_11_2017.Vehicles;

/**
 * Класс BatMobile наследуется от CCar и реализует интерфей Swimable
 */
public class BatMobile extends CCar implements Swimable {
    /**
     * имя актера ездившего на бэтмобиле
     */
    public String NameOfOwner;

    public BatMobile(String coordinates, int price, int speed, int year, double engineCapicity,String nameOfOwner) {
        super(coordinates, price, speed, year, engineCapicity);
        NameOfOwner = nameOfOwner;
    }

    public String getNameOfOwner() {
        return NameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        NameOfOwner = nameOfOwner;
    }

    @Override
    public String typeOfMove(){
        return "ride,swim";
    }

    public int speedOfSwim(){
        return (int)(super.getSpeed()*0.8);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;

        BatMobile batMobile = (BatMobile) otherObject;

        return NameOfOwner.equals(batMobile.NameOfOwner);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (NameOfOwner != null ? NameOfOwner.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+", NameOfOwner = " + NameOfOwner;
    }
}
