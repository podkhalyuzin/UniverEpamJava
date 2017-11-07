package com.company.Task1_03_11_2017;

import java.util.Arrays;

/**
 * класс предназначеный для упорядочивания массивов
 * делает задания 1,2,3 и 4
 */
public class ArraysArranger {

    /**
     * Метод упорядочивает одномерный масиве, вначале отрицательные по возрастанию
     * затем положительные по убыванию.
     */
    public static void negativeAscendingPositiveDescending(int[] array){
        negativePositive(array); // отделяем отрицательные от положительных (задание 2)
        int NegativeCounter=0; //включая 0
        for(int i=0;i<array.length;i++)
            if (array[i] <= 0)
                NegativeCounter++;
        //сортируем отрицательные пузырьком
        for(int i=0;i<NegativeCounter-1;i++){
            for(int j=0;j<NegativeCounter-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        //сортируем положительные пузырьком в обратном порядке
        for(int i=NegativeCounter;i<array.length-1;i++){
            for(int j=NegativeCounter;j<array.length-1-(i-NegativeCounter);j++){
                if(array[j]<array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * Метод в одномерном массиве сначала положительные потом отрицательные за О(n)
     */
    public static void negativePositive(int[] array){
        int NegativeCounter=0; // счетчик колличества негативных чисел
        for(int i=0;i<array.length;i++){
            if(array[i]<0){
                int temp;
                temp=array[i];
                array[i]=array[NegativeCounter];
                array[NegativeCounter]=temp;
                NegativeCounter++;
            }
        }
    }

    /**
     * Метод Упорядочивает столбцы по убыванию среднего значения
     */
    public static void arrangeByAvarage(int[][] array){
        double [] AvarageNumbers = new double[array.length]; //массив средних значений для каждой строки
        for(int i=0;i<array.length;i++){
            int avarageInLine=0;
            for(int j=0;j<array[i].length;j++){
                avarageInLine+=array[i][j];
            }
            AvarageNumbers[i]=(double)avarageInLine/array[i].length;
        }
        //сортируем пузырьком в соответствии с массивом AvarageNumbers[]
        for(int i=0;i<AvarageNumbers.length-1;i++){
            for(int j=0;j<AvarageNumbers.length-1-i;j++){
                if(AvarageNumbers[j]<AvarageNumbers[j+1]){
                    double TempAvarage = AvarageNumbers[j];
                    AvarageNumbers[j] =AvarageNumbers[j+1];
                    AvarageNumbers[j+1] = TempAvarage;
                    int[] TempArray = array[j];
                    array[j] =array[j+1];
                    array[j+1] = TempArray;
                }
            }
        }
    }

    /**
     *  Метод упорядочивает строки, по возрастанию по самой длинной серии одинаковых элементов
     */
    public static void arrangeByLongestSequenceOfEqualElements(int[][] array){
        int[] AmountOfEqualnInLine = new int[array.length]; //массив в котором храниться длина максимальной
                                                            // последовательности в каждой строк
        for(int i=0;i<array.length;i++) {
            int LongestSequense = 1; // длина максимальной последовательности равных элементов
            int LengthCounter = 1; // считает длину последовательности
                                   // и если она болше чем LongestSequense записывается в LongestSequense
            for (int j = 0; j < array[i].length-1; j++) {
                if (array[i][j] == array[i][j+1] && j!=array[i].length-2)
                    LengthCounter++;
                else if(array[i][j] == array[i][j+1] && j==array[i].length-2){
                    LengthCounter++;
                    if (LongestSequense < LengthCounter) {
                        LongestSequense = LengthCounter;
                    }
                }
                else if (LongestSequense < LengthCounter){
                        LongestSequense = LengthCounter;
                        LengthCounter = 1;
                }
                else LengthCounter = 1;

            }
            AmountOfEqualnInLine[i] = LongestSequense;
        }
         //сортируем пузырьком array в соответствии AmountOfEqualnInLine
         for(int i=0;i<AmountOfEqualnInLine.length-1;i++){
             for(int j=0;j<AmountOfEqualnInLine.length-1-i;j++){
                 if(AmountOfEqualnInLine[j]>AmountOfEqualnInLine[j+1]){
                     int TempAvarage = AmountOfEqualnInLine[j];
                     AmountOfEqualnInLine[j] =AmountOfEqualnInLine[j+1];
                     AmountOfEqualnInLine[j+1] = TempAvarage;
                     int[] TempArray = array[j];
                     array[j] =array[j+1];
                     array[j+1] = TempArray;
                 }
             }
         }
         for(int i=0;i<AmountOfEqualnInLine.length;i++)
             System.out.println("В "+(i+1)+"-ой строке "+AmountOfEqualnInLine[i]+" одинаковых элемент(а/ов)");
    }
}
