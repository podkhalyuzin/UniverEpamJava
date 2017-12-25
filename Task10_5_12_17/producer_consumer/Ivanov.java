package com.company.Task10_5_12_17.producer_consumer;

import java.util.Stack;

/**
 * поток выносящий со склада вещи
 */
public class Ivanov implements Runnable {

    /**
     * стек вещей выносящихся со склада
     */
    private Stack<Object> equipment = new Stack<Object>();

    /**
     * колличество товаров на складе
     */
    private int amountEquipment;
    private Petrov petrov;

    public Ivanov(int amountEquipment,Petrov petrov) {
        this.amountEquipment = amountEquipment;
        this.petrov =  petrov;
    }

    @Override
    public void run() {
        while(amountEquipment!=0) {
            if(!equipment.isEmpty()) {
                synchronized (petrov) {
                    petrov.notify();
                }
            }
            System.out.println("take from storage; "+(--amountEquipment)+ " left");
            equipment.push(new Object());
        }
    }

    public Stack<Object> getEquipment() {
        return equipment;
    }
}
