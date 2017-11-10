package com.company.Task2_07_11_2017.Vehicles;

/**
 * абстрактный класс СVehicle. Класс имеет возможность задавать и получать
 * координаты, параметры средств передвижения(цена, скоростьб,год выпуска).
 */
public abstract class CVehicle {
    /**
     * Координаты задаются в виде "51.5074° N, 0.1278° W"
     */
    private String Coordinates;
    /**
     * Цена задается в USD
     */
    private int Price;
    /**
     * Скорость задется в км/ч
     */
    private int Speed;
    private int Year;

    public CVehicle(String coordinates,int price,int speed,int year) {
        Coordinates = coordinates;
        Price = price;
        Speed = speed;
        Year = year;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if(otherObject==null) return false;
        if (!(otherObject instanceof CVehicle)) return false;

        CVehicle cVehicle = (CVehicle) otherObject;

        return Price == cVehicle.Price &&
               Speed == cVehicle.Speed && Year == cVehicle.Year &&
               Coordinates.equals(cVehicle.Coordinates);
    }

    @Override
    public int hashCode() {
        int result = Coordinates.hashCode();
        result = 31 * result + Price;
        result = 31 * result + Speed;
        result = 31 * result + Year;
        return result;
    }

    @Override
    public String toString() {
        return  "Coordinates = " + Coordinates +
                ", Price = " + Price +
                ", Speed = " + Speed +
                ", Year = " + Year;
    }
}
