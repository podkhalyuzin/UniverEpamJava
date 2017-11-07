package com.company.Task0_02_11_2017;

public class FigurePrinter {

    public static final String star = "* ";
    public static final String gap = "  ";
    public static final String indent = "\n";

    /**
     *   Метод печатает прямоугольник по заданым длине и ширине
     */
    public static void printRectangle(int length,int width){
        for(int i=0;i<width;i++){
            if(i!=0 && i!=width-1){
                for(int j=0;j<length;j++){
                    if(j==0)
                        System.out.print(star);
                    else if(j!=length-1)
                        System.out.print(gap);
                    else{
                        System.out.print(star);
                        System.out.print(indent);
                    }
                }
            }
            else{
                for(int j=0;j<length;j++){
                    System.out.print(star);
                }
                System.out.print(indent);
            }
        }
    }

    /**
     *  Метод печатает прямоугольный треугольник с заданым катетом
     */
    public static void printRectangularTriangle(int cathetus){
        for(int i=0;i<cathetus;i++){
            System.out.print(star);
            if(i==0){
                System.out.print(indent);
                continue;
            }
            if(i!=cathetus-1 && i!=0){
                for(int j=0;j<i-1;j++){
                    System.out.print(gap);
                }
                System.out.print(star);
            }
            else{
                for(int j=0;j<cathetus-1;j++){
                    System.out.print(star);
                }
            }
            System.out.print(indent);
        }
    }

    /**
     *  Метод печатает ровнобедренный треугольник с заданой высотой
     */
    public static void printIsoscalesTriangle(int height){
        int base=2*height-1;  // длинна основания треугольника
        for(int i=0;i<height;i++){
            if(i!=height-1){
                for(int j=0;j<base;j++){
                    if(j!=(base-1)/2-i && j!=(base-1)/2+i)
                        System.out.print(gap);
                    else System.out.print(star);
                }
                System.out.print(indent);
            }
            else{
                for(int j=0;j<base;j++)
                    System.out.print(star);
            }
        }
        System.out.print(indent);
    }

    /**
     *   Метод печатает ромб по заданой диагонали
     *   Диагональ должна иметь нечётную длину
     */
    public static void printRhombus(int diagonale){
        if(diagonale%2==0){
            System.out.println("Диагональ должна иметь нечётную длину");
            return;
        }
        int secondDiagonale=diagonale;
        for(int i=0;i<(diagonale+1)/2;i++){
            for(int j=0;j<secondDiagonale;j++){
                if(j!=(secondDiagonale-1)/2-i && j!=(secondDiagonale-1)/2+i)
                    System.out.print(gap);
                else System.out.print(star);
            }
            System.out.print(indent);
        }
        for(int i=(diagonale+1)/2;i<diagonale;i++){
            for(int j=0;j<secondDiagonale;j++){
                if(j!=(secondDiagonale-1)/2-(diagonale-i-1) && j!=(secondDiagonale-1)/2+(diagonale-i-1))
                    System.out.print(gap);
                else System.out.print(star);
            }
            System.out.print(indent);
        }

    }
}
