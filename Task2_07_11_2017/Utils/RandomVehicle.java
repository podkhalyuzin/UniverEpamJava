package com.company.Task2_07_11_2017.Utils;

import com.company.Task2_07_11_2017.Vehicles.*;

import java.util.Random;

/**
 * Класс предназначен для генерации объектов СVehicle
 */
public class RandomVehicle {
    public static CVehicle randomVehicle() {
        Random r = new  Random();
        return nextVehicle(r.nextInt(8));
    }
    public static CVehicle nextVehicle(int key) {

        switch (key) {
            case 0: return new CPlane("51.5074° N, 0.1278° W",400_000,800,2005,20_000,120);
            case 1: return new CShip("46.4825° N, 30.7233° E",1_500_000,70, 2010,500,"Odessa" );
            case 2: return new CCar("24.7136° N, 46.6753° E",40_000,180,2013,2.5);
            case 3: return new BatMobile("50.8052° N, 5.3135° E",140_000,320,1965,5,"Shawn Conery");
            case 4: return new AmphibiousAutomobile("24.7136° N, 46.6753° E",30_000,180,2013,2.5);
            case 5: return new CPlane("51.5074° N, 0.1278° W",2_000_000,950,2002,30_000,110);
            case 6: return new CCar("24.7136° N, 46.6753° E",50_000,200,2011,3.5);
            case 7: return new CShip("46.4825° N, 30.7233° E",3_200_000,60, 1996,700,"Chernomorsk" );
            default: return null;
        }
    }
}
