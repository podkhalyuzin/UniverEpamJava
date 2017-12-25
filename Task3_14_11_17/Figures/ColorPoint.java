package com.company.Task3_14_11_17.Figures;

import com.company.Task3_14_11_17.Figures.Point;

import java.io.Serializable;

public class ColorPoint extends Point implements Colorful,Serializable{

    private int color;

    public ColorPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }
    public int getColor() {
        return color;
    }
    public void setColor(int color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "ColorPoint [color=" + color + ", X=" + getX() + ", Y=" + getY() + "]";
    }
}
