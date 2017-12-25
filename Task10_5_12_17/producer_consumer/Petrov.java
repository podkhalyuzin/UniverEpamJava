package com.company.Task10_5_12_17.producer_consumer;

import java.util.Stack;

public class Petrov implements Runnable{

    private Stack<Object> equipment = new Stack<Object>();
    private Nechyporuk nechyporuk; // should be notified
    private int amountEquipment;

    public Petrov(int amountEquipment, Nechyporuk nechyporuk) {
        this.amountEquipment = amountEquipment;
        this.nechyporuk = nechyporuk;
    }

    @Override
    public void run() {
        Ivanov ivanov = new Ivanov(amountEquipment,this);
        Thread ivanovThread = new Thread(ivanov);
        ivanovThread.start();
        while(amountEquipment!=0) {
            if (!equipment.isEmpty()) {
                synchronized (nechyporuk) {
                    nechyporuk.notify();
                }
            }
            if(ivanov.getEquipment().isEmpty()) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("bring to truck; "+(--amountEquipment)+ " left");
            equipment.push(ivanov.getEquipment().pop());
        }
    }

    public Stack<Object> getEquipment() {
        return equipment;
    }

    public int getAmountEquipment() {
        return amountEquipment;
    }
}
