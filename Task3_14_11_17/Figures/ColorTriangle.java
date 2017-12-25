package com.company.Task3_14_11_17.Figures;

import java.io.Serializable;

public class ColorTriangle extends Triangle implements Colorful,Serializable {

    private int color;

    public ColorTriangle(Point apexA, Point apexB, Point apexC, int color) {
        super(apexA, apexB, apexC);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
