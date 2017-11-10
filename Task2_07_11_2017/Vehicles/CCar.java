package com.company.Task2_07_11_2017.Vehicles;

/**
 * Класс CCar наследуется от CVehicle и реализует интерфей Moveable
 */
public class CCar extends CVehicle implements Moveable {
    /**
     * Объем двигателя задается в литрах
     */
    private double EngineCapicity;

    public CCar(String coordinates, int price, int speed, int year, double engineCapicity) {
        super(coordinates, price, speed, year);
        EngineCapicity = engineCapicity;
    }

    public double getEngineCapicity() {
        return EngineCapicity;
    }

    public void setEngineCapicity(int engineCapicity) {
        EngineCapicity = engineCapicity;
    }

    public String typeOfMove(){
        return "ride";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if(otherObject == null) return false;
        if (!(otherObject instanceof CCar)) return false;
        if (!super.equals(otherObject)) return false;

        CCar cCar = (CCar) otherObject;

        return (EngineCapicity-cCar.EngineCapicity)<0.01;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int)EngineCapicity;
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+", EngineCapicity = " + EngineCapicity;
    }
}
