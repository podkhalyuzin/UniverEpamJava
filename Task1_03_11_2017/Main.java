package com.company.Task1_03_11_2017;

/**
 * Сортировка последовательности
 * 1. Упорядочить одномерный масиве вначале отрицательные повозрастанию
 * затем положительные по убыванию.
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n).
 * Дана целочисленная прямоугольная матрица.
 * 3. Упорядочить столбцы по убыванию среднего значения.
 * 4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 * 5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
 * ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
 * менты по спирали: первая строка, последний столбец, последняя строка в
 * обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  элементы
 * второй строки и т. д.; последним выводится центральный элемент матрицы.
 */

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Задание №1
        System.out.println("1.Упорядочивание отрицательных и положительных:");
        int[] ArrayTest1 = new int[50];
        System.out.println("Было");
        for(int i=0;i<ArrayTest1.length;i++) {
            ArrayTest1[i]=(int) (Math.random() * 100-50);
            System.out.print(ArrayTest1[i]+" ");
        }
        System.out.println();
        ArraysArranger.negativeAscendingPositiveDescending(ArrayTest1);
        System.out.println("Стало");
        for(int i=0;i<ArrayTest1.length;i++) {
            System.out.print(ArrayTest1[i]+" ");
        }
        System.out.println();

        // Задание №2
        System.out.println();
        System.out.println("2.отделение отрицательных от положительных за O(n):");
        int[] ArrayTest2 = new int[50];
        System.out.println("Было");
        for(int i=0;i<ArrayTest2.length;i++) {
            ArrayTest2[i]=(int) (Math.random() * 100-50);
            System.out.print(ArrayTest2[i]+" ");
        }
        System.out.println();
        ArraysArranger.negativePositive(ArrayTest2);
        System.out.println("Стало");
        for(int i=0;i<ArrayTest2.length;i++) {
            System.out.print(ArrayTest2[i]+" ");
        }
        System.out.println();

        // Задание №3
        System.out.println();
        System.out.println("3.Упорядочивание по среднему значению:");
        int[][] TestArray3 = new int[6][13];
        for(int i=0;i<6;i++){
            for(int j=0;j<13;j++){
                TestArray3[i][j]=(int)(Math.random()*100);
            }
        }
        ArraysArranger.arrangeByAvarage(TestArray3);
        for(int i=0;i<6;i++){
            int avarageInLine=0;
            for(int j=0;j<13;j++){
                System.out.print(TestArray3[i][j]+" ");
                avarageInLine+=TestArray3[i][j];
            }
            System.out.println("Avarage = "+(double)avarageInLine/TestArray3[i].length);
        }

        // Задание №4
        System.out.println();
        System.out.println("4.Упорядочивание строк, по возрастанию самой длинной серии одинаковых элементов:");
        int[][] ArrayTest4 = new int[7][15];
        // формируем массив 7х15 из значений 0,1,2
        for(int i=0;i<7;i++) {
            for(int j=0;j<15;j++){
                ArrayTest4[i][j]=(int) (Math.random() * 100)%3;
            }
        }
        ArraysArranger.arrangeByLongestSequenceOfEqualElements(ArrayTest4);
        for(int i=0;i<7;i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(ArrayTest4[i][j] + " ");
            }
            System.out.println();
        }

        // Задание №5
        System.out.println();
        System.out.println("5.Обход матрицы по часовой стрелке:");
        int[][] TestArray5 = new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                TestArray5[i][j]=(int)(Math.random()*100)%10;
                System.out.print(TestArray5[i][j]+" ");
            }
            System.out.println();
        }

        ArrayPrinter.printSpiral(TestArray5);

    }
}
