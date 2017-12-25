package com.company.Task3_14_11_17.Figures;

import java.io.Serializable;

public class ColorPolygon extends Polygon implements Colorful,Serializable {

    private int color;

    public ColorPolygon(Point[] Apexes,int color) {
        super(Apexes);
        this.color = color;
    }

    public ColorPolygon(int NumberOfApexes,int color,int... coordinates) throws IllegalArgumentException{
        super(NumberOfApexes,coordinates);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
