package com.company.Task3_14_11_17.Utils;

import com.company.Task3_14_11_17.Figures.*;

import java.util.Random;

public class RegularFactory implements FigureFactory {

    public Figure createFigure(){
        Random r  = new Random();
        int key = r.nextInt(4);
        return nextFigure(key);
    }


    public static Figure nextFigure(int key) {
        switch (key) {
            case 0:
                return new Point(2,1);
            case 1:
                return new Line(0,1,4,-2);
            case 2:
                return new Triangle(new Point(0,0),new Point(-4,3),new Point(5,2));
            case 3:
                return new Polygon(5,-3,0,-1,3,0,4,3,2,0,-5);
            default: return null;
        }
    }
}
