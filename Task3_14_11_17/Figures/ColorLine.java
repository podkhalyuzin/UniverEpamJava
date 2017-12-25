package com.company.Task3_14_11_17.Figures;

import java.io.Serializable;

public class ColorLine extends Line implements Colorful,Serializable{

    private int color;

    public ColorLine(Point begin, Point end, int color) {
        super(begin, end);
        this.color = color;
    }

    public ColorLine(int x1, int y1,int x2, int y2, int color) {
        super(x1,y1,x2,y2);
        this.color = color;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorLine [color=" + color + ", Beg = " + getBegin() + ", End =" + getEnd() + "]";
    }

}
