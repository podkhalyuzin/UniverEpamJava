package com.company.Task10_5_12_17.producer_consumer;

import java.util.Stack;

public class Nechyporuk implements Runnable {

    private Stack<Object> equipment = new Stack<Object>();
    private int amountEquipment;

    public Nechyporuk(int amountEquipment) {
        this.amountEquipment = amountEquipment;
    }

    @Override
    public void run() {
        Petrov petrov = new Petrov(amountEquipment,this);
        Thread petrovThread = new Thread(petrov);
        petrovThread.start();
        while(amountEquipment!=0) {
            if(petrov.getEquipment().isEmpty()) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("count cost; "+(--amountEquipment)+ " left");
            equipment.push(petrov.getEquipment().pop());
        }
    }
}
