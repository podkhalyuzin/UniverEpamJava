package com.company.Task3_14_11_17.Figures;

import com.company.Task3_14_11_17.Utils.PointsWorker;

import java.io.Serializable;
import java.util.Arrays;

public class Polygon implements Figure,Serializable {

    Point[] Apexes;
    Line[] Sides;

    public Polygon(Point[] Apexes) {
        if(PointsWorker.IsThreePointsInLine(Apexes)){
            this.Apexes=null;
            return;
        }
        this.Apexes = Apexes;
    }

    /**
     *
     * @param NumberOfApexes
     * @param coordinates
     * @throws IllegalArgumentException если число вершин не соответствует колличеству координат
     */
    public Polygon(int NumberOfApexes,int... coordinates) throws IllegalArgumentException{
        if(coordinates.length!=NumberOfApexes*2)
            throw new IllegalArgumentException("arrays length and number of apexes are nit collocated");
        this.Apexes = new Point[NumberOfApexes];
        int i=0;
        for(int j=0;j<coordinates.length-1;j=j+2){
            Apexes[i++] = new Point(coordinates[j],coordinates[j+1]);
        }
        if(PointsWorker.IsThreePointsInLine(this.Apexes))
            this.Apexes=null;
    }

    public Point[] getApexes() {
        return Apexes;
    }

    public void setApexes(Point[] Apexes) {
        this.Apexes = Apexes;
    }

    public void setApexes(int... coordinates) {
        for(int i=0;i<2*coordinates.length;i++){
            Apexes[i] = new Point(i,++i);
        }
    }

    public Point getApexByIndex(int i){
        return Apexes[i];
    }

    public Line getSide(int Ai , int Aj){
        if(Math.abs(Ai-Aj)!=1 || Math.abs(Ai-Aj)!=Apexes.length-2)
            return null;
        return new Line(Apexes[Ai],Apexes[Aj]);
    }

    public void setApex(Point p,int i) {
        Apexes[i] = p;
        if(i!=Apexes.length-1){
            Sides[i]=null;
            Sides[i+1]=null;
        }
        else{
            Sides[0]=null;
            Sides[Apexes.length-1]=null;
        }
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "Apexes=" + Arrays.toString(Apexes) +
                ", Sides=" + Arrays.toString(Sides) +
                '}';
    }

    /**
     * корректно только если многоугольник выпуклый
     * @return площадь многоугольника
     */
    public double square(){
        double result = 0.;
        for(int i=1;i<Apexes.length-1;i++){
            Triangle triangle = new Triangle(Apexes[0],Apexes[i],Apexes[i+1]);
            result+=triangle.square();
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Polygon)) return false;

        Polygon polygon = (Polygon) object;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(Apexes, polygon.Apexes);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(Apexes);
    }
}
