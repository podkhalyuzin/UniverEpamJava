package com.company.Task0_02_11_2017;

/**
 * Используя циклы и методы System.out.print("* "), System.out.print(" "),
 * System.out.print("\n") (для перехода на новую строку).
 * Выведите на экран:
 * - прямоугольник
 * - прямоугольный треугольник
 * - равносторонний треугольник
 * - ромб
 */
public class Main {

    public static void main(String[] args) {
        // write your code here
        FigurePrinter.printRectangle(12, 5);
        FigurePrinter.printRectangularTriangle(9);
        FigurePrinter.printIsoscalesTriangle(6);
        FigurePrinter.printRhombus(11);
    }
}
