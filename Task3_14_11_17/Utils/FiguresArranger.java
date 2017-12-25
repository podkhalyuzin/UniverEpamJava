package com.company.Task3_14_11_17.Utils;

import com.company.Task3_14_11_17.Figures.*;

/**
 * Класс работает с массивами фигур
 */
public class FiguresArranger {

    /**
     * создает массив цветных фигур
     * @param size размер массива
     * @return массив цветных фигур
     */
    public static Figure[] createColorfulFiguresArray(int size){
        FigureFactory factory = new ColorfulFactory();
        Figure[] result = new Figure[size];
        for(int i=0;i<size;i++){
            result[i] = factory.createFigure();
        }
        return result;
    }

    public static Figure[] createRegularFiguresArray(int size){
        FigureFactory factory = new RegularFactory();
        Figure[] result = new Figure[size];
        for(int i=0;i<size;i++){
            result[i] = factory.createFigure();
        }
        return result;
    }

    /**
     * возвращает колличество точек в массиве figures
     * @param figures
     * @return колличество точек
     */
    public static int getNumberOfPoints(Figure[] figures){
        int result=0;
        for(Figure element : figures){
            if(element instanceof Point )
                result++;
        }
        return result;
    }

    public static int getNumberOfLines(Figure[] figures){
        int result=0;
        for(Figure element : figures){
            if(element instanceof Line )
                result++;
        }
        return result;
    }

    public static int getNumberOfTriangles(Figure[] figures){
        int result=0;
        for(Figure element : figures){
            if(element instanceof Triangle )
                result++;
        }
        return result;
    }

    public static int getNumberOfPolygons(Figure[] figures){
        int result=0;
        for(Figure element : figures){
            if(element instanceof Polygon )
                result++;
        }
        return result;
    }

    /**
     * возвращает массив точек которые лежат в figures
     * @param figures массив из фигур
     * @return массив точек которые лежат в figures
     */
    public static Point[] groupByPoints(Figure[] figures){
        Point[] result = new Point[getNumberOfPoints(figures)];
        int j=0;
        for(int i=0;i<figures.length;i++){
            if(figures[i] instanceof Point)
                result[j++]=(Point)figures[i];
        }
        return result;
    }

    public static Line[] groupByLines(Figure[] figures){
        Line[] result = new Line[getNumberOfLines(figures)];
        int j=0;
        for(int i=0;i<figures.length;i++){
            if(figures[i] instanceof Line)
                result[j++]=(Line)figures[i];
        }
        return result;
    }

    public static Triangle[] groupByTriangle(Figure[] figures){
        Triangle[] result = new Triangle[getNumberOfTriangles(figures)];
        int j=0;
        for(int i=0;i<figures.length;i++){
            if(figures[i] instanceof Triangle)
                result[j++]=(Triangle)figures[i];
        }
        return result;
    }

    public static Polygon[] groupByPolygons(Figure[] figures){
        Polygon[] result = new Polygon[getNumberOfPolygons(figures)];
        int j=0;
        for(int i=0;i<figures.length;i++){
            if(figures[i] instanceof Polygon)
                result[j++]=(Polygon)figures[i];
        }
        return result;
    }
}
