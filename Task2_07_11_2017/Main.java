package com.company.Task2_07_11_2017;

import com.company.Task2_07_11_2017.Utils.RandomVehicle;
import com.company.Task2_07_11_2017.Vehicles.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Создать абстрактный класс СVehicle. На его основе реализвать СPlane, CCar и CShip.
 * Классы должны иметь возможность задавать и получать координаты, параметры средств
 * передвижения(цена, скоростьб,год выпуска). Для самолёта должна быть определена
 * высота, для самолёта и корабля - колличество пассажиров. Для корабля - порт приписки.
 * 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет;
 * 2. найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000;
 * 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane;
 * 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых
 * по Интерфейсам Flyable, MoveAble, SwimAble;
 */
public class Main {
    
    public static void main(String[] args) {
	// write your code here
        //Массив хранит 50 средств передвижения CVehicle


        CVehicle[] vehicles = new CVehicle[50];
        for(int i=0;i<50;i++)
            vehicles[i]= RandomVehicle.randomVehicle();

        System.out.println("Задание№1");
        // списочные массивы хранят объекты с наименьшей ценой с наибольшей скоростью и не старше 5 лет
        ArrayList<CVehicle> NotOlderThan5Years = new ArrayList<CVehicle>();
        ArrayList<CVehicle>  MaxSpeed = new ArrayList<CVehicle>();
        ArrayList<CVehicle>  MinCoast = new ArrayList<CVehicle>();
        Date currentDate = new Date();
        int maxSpeed=vehicles[0].getSpeed();
        int minCoast=vehicles[0].getPrice();
        //определение максимальной скорости и минимальной цены
        for(int i=0;i<50;i++){
            if(vehicles[i].getSpeed()>maxSpeed)
                maxSpeed=vehicles[i].getSpeed();
            if(vehicles[i].getPrice()<minCoast)
                minCoast=vehicles[i].getPrice();
        }
        for(int i=0;i<50;i++){
            if(currentDate.getYear()-vehicles[i].getYear()>5)
                NotOlderThan5Years.add(vehicles[i]);
            if(vehicles[i].getSpeed()==maxSpeed)
                MaxSpeed.add(vehicles[i]);
            if(vehicles[i].getPrice()==minCoast)
               MinCoast.add(vehicles[i]);
        }
        System.out.println("Максимальная скорость: "+MaxSpeed.toString());
        System.out.println("Минимальная цена: "+MinCoast.toString());

        System.out.println();
        System.out.println("Задание№2");
        // списочный массив самолётов c высотой полета выше 5000 с годом выпуска после 2000
        ArrayList<CPlane> NecessaryPlanes = new ArrayList<CPlane>();
        for(int i=0;i<vehicles.length;i++){
            if(vehicles[i] instanceof CPlane){
                CPlane plane = (CPlane)vehicles[i];
                if(plane.getHeight()>5000 && plane.getYear()>2000)
                    NecessaryPlanes.add(plane);
            }
        }
        System.out.println("Самолёты с высотой полета выше 5000 с годом выпуска после 2000: "+NecessaryPlanes.toString());

        System.out.println();
        System.out.println("Задание№3");
        //списочный массив объектов с максимальной скоростью в диапазоне 200 - 500, но не Plane
        ArrayList<CVehicle> SpeedWithin200500= new ArrayList<CVehicle>();
        for(int i=0;i<vehicles.length;i++){
            if(vehicles[i] instanceof CPlane)
                continue;
            if(vehicles[i].getSpeed()>200 && vehicles[i].getSpeed()<500){
                SpeedWithin200500.add(vehicles[i]);
            }
        }
        System.out.println("Mеханизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane: "+SpeedWithin200500.toString());

        System.out.println();
        System.out.println("Задане№4");
        //списочные массивы для хранения объектов реализующие укзанные интерфейсы
        ArrayList<Moveable> moveable = new ArrayList<Moveable>();
        ArrayList<Flyable> flyable= new ArrayList<Flyable>();
        ArrayList<Swimable> swimable= new ArrayList<Swimable>();
        for(int i=0;i<50;i++){

            if(vehicles[i] instanceof Flyable){
                flyable.add((Flyable) vehicles[i]);
                moveable.add((Moveable) vehicles[i]);
            }
            else if(vehicles[i] instanceof Swimable){
                swimable.add((Swimable) vehicles[i]);
                moveable.add((Moveable) vehicles[i]);
            }
            else if(vehicles[i] instanceof Moveable)
                moveable.add((Moveable) vehicles[i]);
        }
        System.out.println("Moveable : "+moveable.toString());
        System.out.println("Flyable : "+flyable.toString());
        System.out.println("Swimable : "+swimable.toString());
    }
}
