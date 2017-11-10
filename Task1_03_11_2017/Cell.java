package com.company.Task1_03_11_2017;

/**
 * Вспомогательный класс для com.company.Task1_03_11_2017.labyrinth
 * Хранит координаты клетки
 */
class Cell{
    private int first,second;

    public Cell(int first, int second){
        this.first = first;
        this.second = second;
    }

    public int getFirst(){
        return this.first;
    }

    public int getSecond(){
        return this.second;
    }

    public String toString(){
        return "[ "+first+", "+second+" ]";
    }

}
