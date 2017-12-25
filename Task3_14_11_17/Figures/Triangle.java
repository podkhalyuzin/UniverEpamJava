package com.company.Task3_14_11_17.Figures;
import com.company.Task3_14_11_17.Utils.PointsWorker;

import java.io.Serializable;

public class Triangle implements Figure,Serializable {
    Point apexA, apexB, apexC;
    Line sideAB, sideBC, sideAC;

    public Point getApexA() {
        return apexA;
    }

    public Triangle(Point apexA, Point apexB, Point apexC) {
        if(PointsWorker.IsLine(apexA,apexB,apexC))
            return;
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
    }

    public Line getSideAB() {
        if (sideAB==null)
            sideAB = new Line(apexA, apexB);
        return sideAB;
    }

    public Line getSideBC() {
        if (sideBC==null)
            sideBC = new Line(apexB, apexC);
        return sideBC;
    }

    public Line getSideAC() {
        if (sideAC==null)
            sideAC = new Line(apexA, apexC);
        return sideAC;
    }

    public void setApexA(Point p) {
        if(PointsWorker.IsLine(p,apexB,apexC))
            return;
        apexA=p;
        sideAB=null;
        sideAC=null;
    }

    public void setApexB(Point p) {
        if(PointsWorker.IsLine(p,apexA,apexC))
            return;
        apexB=p;
        sideAB=null;
        sideBC=null;
    }

    public void setApexC(Point p) {
        if(PointsWorker.IsLine(p,apexA,apexB))
            return;
        apexC=p;
        sideBC=null;
        sideAC=null;
    }

    /**
     * Метод считает площадь треугольник
     * @return площадь треугольника
     */
    public double square(){
        double p = (this.getSideAB().length()+this.getSideBC().length()+this.getSideAC().length())*0.5;
        //формула Герона
        return Math.sqrt(p*(p-sideAB.length())*(p-sideBC.length())*(p-sideAC.length()));
    }
}
