package com.company.Task3_14_11_17.Utils;

import com.company.Task3_14_11_17.Figures.*;
import java.util.Random;

public class ColorfulFactory implements FigureFactory {

    public Figure createFigure(){
        Random r  = new Random();
        int key = r.nextInt(4);
        return nextFigure(key);
    }

    public static Figure nextFigure(int key) {
        switch (key) {
            case 0:
                return new ColorPoint(3, 2, 248);
            case 1:
                return new ColorLine(1, 0, 3, -1, 654);
            case 2:
                return new ColorTriangle(new Point(0, 4), new Point(-4, -3), new Point(1, -2), 731);
            case 3:
                return new ColorPolygon(4, 954, -3, 0, 0, 4, 3, 2, 0, -5);
            default: return null;
        }
    }
}
