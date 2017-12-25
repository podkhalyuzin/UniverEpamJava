package com.company.Task3_14_11_17.Figures;

import java.io.Serializable;

public class Line implements Figure,Serializable{

    private Point begin;
    private Point end;

    public Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.begin = new Point(x1,y1);
        this.end = new Point(x2,y2);
    }

    public Point getBegin() {
        return begin;
    }
    public void setBegin(Point begin) {
        this.begin = begin;
    }
    public Point getEnd() {
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }

    public double length(){
        double X = Math.pow(begin.getX()-end.getX(),2);
        double Y = Math.pow(begin.getY()-end.getY(),2);
        return Math.sqrt(X+Y);
    }

}
