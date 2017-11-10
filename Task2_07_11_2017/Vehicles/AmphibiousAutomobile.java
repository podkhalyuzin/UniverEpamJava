package com.company.Task2_07_11_2017.Vehicles;

/**
 * Класс AmphibiousAutomobile наследуется от CCar и реализует интерфей Swimable
 */
public class AmphibiousAutomobile extends CCar implements Swimable {

    public AmphibiousAutomobile(String coordinates, int price, int speed, int year, double engineCapicity) {
        super(coordinates, price, speed, year, engineCapicity);
    }

    @Override
    public String typeOfMove() {
        return "ride,swim";
    }

    public int speedOfSwim(){
        return (int) (super.getSpeed()*0.6);
    }
}
