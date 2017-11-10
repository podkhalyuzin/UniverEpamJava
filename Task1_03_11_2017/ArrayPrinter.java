package com.company.Task1_03_11_2017;

import java.util.Stack;

/**
 * класс предназначеный для печати массивов
 * делает задание 5
 */
public class ArrayPrinter {
    /**
     * Дана квадратная матрица A порядка M (M — нечетное число).МЕТОД Начи-
     * ная с элемента A1,1 и перемещаясь по часовой стрелке, выводит все ее эле-
     * менты по спирали: первая строка, последний столбец, последняя строка в
     * обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  элементы
     * второй строки и т. д.; последним выводится центральный элемент матрицы.
     */
    public static void printSpiral(int[][] array){
        int line = array.length; //сторона даного квадрата, в условии обозначено М
        FullPrinter:
        for(int i=0;i<(line-1)/2;i++){
            LeftRight:
            for(int j=i;j<line-i;j++){
                System.out.print(array[i][j]+" ");
            }
            UpDown:
            for(int j=i+1;j<line-i;j++){
                System.out.print(array[j][line-i-1]+" ");
            }
            RightLeft:
            for(int j=line-i-2;j>=i;j--){
                System.out.print(array[line-i-1][j]+" ");
            }
            DownUp:
            for(int j=line-2-i;j>i;j--){
                System.out.print(array[j][i]+" ");
            }
        }
        System.out.print(array[(line-1)/2][(line-1)/2]);
    }

    /**
     * Метод ищет выход из лабиринта
     * @param N - лабиринт,матрица из 0 и 1
     */
    public void labyrinth(int[][] N){
        int X = N.length;
        int Y = N[0].length;
        // 1 - посещённые клетки, 0 - не посещённые
        int[][] Visited = new int[X][Y];
        int i=0; // итераторы в матрице N и Visited,
        int j=0; // а также атрибуты для объектов Cell, которые добавляются в stack
        Visited[0][0]=1;
        Stack<Cell> stack = new Stack<Cell>();
        Cell Current = new Cell(0,0);

        while(Current.getFirst()!=X-1 && Current.getSecond()!=Y-1){
            if(!stack.contains(Current))
                stack.push(Current);
            //крайнее правое положение
            if(j==Y-1 && i!=0){
                if(N[i+1][j]==0 && Visited[i+1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[++i][j]=1;
                }
                else if(N[i-1][j]==0 && Visited[i-1][j]==0){
                    Current = new Cell(i-1,j);
                    Visited[--i][j]=1;
                }
                else if(N[i][j-1]==0 && Visited[i][j-1]==0){
                    Current = new Cell(i,j-1);
                    Visited[i][--j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
                continue;
            }
            //крайнее левое положение
            if(j==0 && i!=X-1){
                if(N[i+1][j]==0 && Visited[i+1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[++i][j]=1;
                }
                else if(N[i][j+1]==0 && Visited[i][j+1]==0){
                    Current = new Cell(i,j+1);
                    Visited[i][++j]=1;
                }
                else if(N[i-1][j]==0 && Visited[i-1][j]==0){
                    Current = new Cell(i-1,j);
                    Visited[--i][j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
                continue;
            }
            //крайнее нижнее положение
            if(i==X-1 && j!=0){
                if(N[i][j+1]==0 && Visited[i][j+1]==0){
                    Current = new Cell(i,j+1);
                    Visited[i][++j]=1;
                }
                else if(N[i-1][j]==0 && Visited[i-1][j]==0){
                    Current = new Cell(i-1,j);
                    Visited[--i][j]=1;
                }
                else if(N[i][j-1]==0 && Visited[i][j-1]==0){
                    Current = new Cell(i,j-1);
                    Visited[i][--j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
                continue;
            }
            //крайнее верхнее положение
            if(i==0 && j!=Y-1){
                if(N[i][j+1]==0 && Visited[i][j+1]==0){
                    Current = new Cell(i,j+1);
                    Visited[i][++j]=1;
                }
                else if(N[i+1][j]==0 && Visited[i+1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[++i][j]=1;
                }
                else if(N[i][j-1]==0 && Visited[i][j-1]==0){
                    Current = new Cell(i,j-1);
                    Visited[i][--j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                }
                continue;
            }
            //правая верхняя ячейка
            if(i==0 && j==Y-1){
                if(N[i+1][j]==0 && Visited[i+1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[++i][j]=1;
                }
                else if(N[i][j-1]==0 && Visited[i][j-1]==0){
                    Current = new Cell(i,j-1);
                    Visited[i][--j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
                continue;
            }
            //левая нижняя ячейка
            if(j==0 && i==X-1){
                if(N[i-1][j]==0 && Visited[i-1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[--i][j]=1;
                }
                else if(N[i][j+1]==0 && Visited[i][j+1]==0){
                    Current = new Cell(i,j+1);
                    Visited[i][++j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
                continue;
            }
            //обычное положение
            else {
                if(N[i][j+1]==0 && Visited[i][j+1]==0){
                    Current = new Cell(i,j+1);
                    Visited[i][++j]=1;
                }
                else if(N[i+1][j]==0 && Visited[i+1][j]==0){
                    Current = new Cell(i+1,j);
                    Visited[++i][j]=1;
                }
                else if(N[i][j-1]==0 && Visited[i][j-1]==0){
                    Current = new Cell(i,j-1);
                    Visited[i][--j]=1;
                }
                else if(N[i-1][j]==0 && Visited[i-1][j]==0){
                    Current = new Cell(i-1,j);
                    Visited[--i][j]=1;
                }
                else {
                    stack.pop();
                    if(stack.empty()) return;
                    Current = stack.peek();
                    i=Current.getFirst();
                    j=Current.getSecond();
                }
            }
        }
        stack.push(new Cell(X-1,Y-1));
        System.out.println(stack.toString());
    }

}


