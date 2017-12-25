package com.company.Task11_7_12_17;

public class Station implements Runnable {

    private Bus[] buses;
    private int maxBuses;
    private volatile boolean isFull = false;
    private Bus nextBus; // will be notified

    /**
     * constructor receives number of busses
     * @param n - number of buses
     */
    public Station(int n) {
        maxBuses = n;
        this.buses = new Bus[n];
    }

    /**
     * check does array buses contain null
     * if yes then return false, otherwise  - return true
     * @return
     */
    public boolean isFull() {
        for(int i=0;i<maxBuses;i++)
            if(buses[i]==null)
                return false;
        return true;
    }

    /**
     * add variable nextBus to array buses
     * and then set variable nextBus as null
     */
    public void addBus(){
        for(int i=0;i<maxBuses;i++){
            if(buses[i]==null) {
                buses[i] = nextBus;
                nextBus=null;
                return;
            }
        }
    }

    public int getMaxBuses() {
        return maxBuses;
    }

    public Bus[] getBuses() {
        return buses;
    }

    public Bus getNextBus() {
        return nextBus;
    }

    public void setNextBus(Bus nextBus) {
        this.nextBus = nextBus;
    }

    public void leave(Bus bus){
        for(int i=0;i<buses.length;i++){
            if(bus==buses[i])
                buses[i]=null;
            return;
        }
    }

    @Override
    public void run(){
        while(true){
            if(!isFull && nextBus!=null){
                synchronized (nextBus){
                    nextBus.notify();
                }
            }
        }
    }
}
