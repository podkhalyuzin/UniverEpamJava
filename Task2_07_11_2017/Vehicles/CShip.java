package com.company.Task2_07_11_2017.Vehicles;

/**
 * Класс CShip наследуется от CVehicle и реализует интерфей Swimable
 */
public class CShip extends CVehicle implements Swimable {
    private int Passangers;
    /**
     * укзывается город
     */
    private String Port;

    public CShip(String coordinates, int price, int speed, int year, int passangers,String port) {
        super(coordinates, price, speed, year);
        Passangers = passangers;
        Port = port;
    }

    public int getPassangers() {
        return Passangers;
    }

    public void setPassangers(int passangers) {
        Passangers = passangers;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String typeOfMove(){
        return "swim";
    }

    public int speedOfSwim(){
        return getSpeed();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (!(otherObject instanceof CShip)) return false;
        if (!super.equals(otherObject)) return false;

        CShip cShip = (CShip) otherObject;

        return Passangers == cShip.Passangers &&
               Port.equals(cShip.Port);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Passangers;
        result = 31 * result + (Port != null ? Port.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+", Passangers = " + Passangers +
                ", Port = " + Port;
    }
}
