package com.company.Task3_14_11_17.Utils;

import com.company.Task3_14_11_17.Figures.Point;

public class PointsWorker {

    public static boolean IsLine(Point A, Point B, Point C){
        if(C.getY()==A.getY() && B.getY()==A.getY())
            return true;
        if((C.getY()==A.getY() && B.getY()!=A.getY()) || (C.getY()!=A.getY() && B.getY()==A.getY()))
            return false;
        if (Math.abs((double)(C.getX()-A.getX()) / (B.getX()-A.getX())-
                (C.getY()-A.getY()) / (B.getY()-A.getY()))<0.001)
            return true;
        return false;
    }

    /**
     * метод проверяет есть ли в массиве точек 3 лежащие на одной прямой
     * @param points массив точек
     * @return true если 3 подряд точки лежат на одной прямой, иначе fasle
     */
    public static boolean IsThreePointsInLine(Point[] points){
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=j+1;k<points.length;k++){
                    if((j-i==1 && k-j==1) ||
                            (i==0 && j==1 && k==points.length-1) ||
                            (i==0 && j==points.length-2)) {
                        if(PointsWorker.IsLine(points[i],points[j],points[k])){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
