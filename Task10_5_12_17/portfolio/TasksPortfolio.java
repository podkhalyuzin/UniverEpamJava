package com.company.Task10_5_12_17.portfolio;

import java.util.Stack;

/**
 * Задача о Винни-Пухе, или неправильные пчелы. Неправильные пчелы, подсчитав в конце месяца убытки
 * от наличия в лесу Винни-Пуха, решили разыскать его и наказать в назидание всем другим любителям сладкого.
 * Для поисков медведя они поделили лес на участки, каждый из которых прочесывает одна стая неправильных пчел.
 * В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
 * Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей. Требуется создать
 * многопоточное приложение, моделирующее действия пчел.
 * При решении использовать парадигму портфеля задач.
 */
public class TasksPortfolio {

    /**
     * лес состои из нулей в которо Винни-Пух отмечен еденицой
     */
    private int[][] forest;

    /**
     * стек задач содержит матрицы размером 2хN (последняя может быть 1хN)
     * NхN  - размер forest
     */
    private Stack<int[][]> tasks = new Stack<int[][]>();

    /**
     * флаг устанавливается в true если Винни-Пух найден
     */
    private volatile boolean isFound = false;

    public TasksPortfolio(int N){
        forest = new int[N][N];
        int i = (int)(Math.random()*N);
        int j = (int)(Math.random()*N);
        forest[i][j] = 1; // координаты Винни-Пуха
        // заполняем стек заданий
        for(int k=0;k<N;k=k+2){
            int[][] task = new int[2][N];
            if(k==i) task[0][j]=1;
            else if(k==i-1) task[1][j]=1;
            tasks.push(task);
        }
    }

    public int[][] getForest() {
        return forest;
    }

    public Stack<int[][]> getTasks() {
        return tasks;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }
}
