package com.company.Task2_07_11_2017.Vehicles;

/**
 * Класс CPlane наследуется от CVehicle и реализует интерфей Flyable
 */
public class CPlane extends CVehicle implements Flyable {
    /**
     * указывается в метрах
     */
    private int Height;
    private int Passangers;

    public CPlane(String coordinates,int price,int speed,int year,int height,int passangers) {
        super(coordinates,price,speed,year);
        Height = height;
        Passangers = passangers;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getPassangers() {
        return Passangers;
    }

    public void setPassangers(int passangers) {
        Passangers = passangers;
    }

    public String typeOfMove(){
        return "fly";
    }

    public int speedOfFly(){
        return getSpeed();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if(otherObject==null) return false;
        if (!(otherObject instanceof CPlane)) return false;
        if (!super.equals(otherObject)) return false;

        CPlane cPlane = (CPlane) otherObject;

        return Height == cPlane.Height &&
               Passangers == cPlane.Passangers;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Height;
        result = 31 * result + Passangers;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Height = " + Height +
                ", Passangers = " + Passangers;
    }
}
