package com.company.Task11_7_12_17;

import static java.lang.Thread.sleep;

public class Bus implements Runnable {

    private Station[] path;
    private Station current;

    public Bus(Station[] stations) {
        this.path = stations;
    }

    public Station[] getPath() {
        return path;
    }

    public void setPath(Station[] path) {
        this.path = path;
    }

    public Station getCurrent() {
        return current;
    }

    public void setCurrent(Station current) {
        this.current = current;
    }

    /**
     * set @param station field NextBus as this
     * and try to add this to @param station field Buses
     * @param station
     * @throws InterruptedException
     */
    public synchronized void takeStation(Station station) throws InterruptedException {
        station.setNextBus(this);
        while(station.isFull())
            wait();
        station.addBus();
        current = station;
    }

    /**
     * set variable current as null
     */
    public void leaveStation(){
        for(int i=0;i<path.length;i++){
            if(path[i]==current) {
                path[i].leave(this);
                break;
            }
        }
        current = null;
    }

    @Override
    public void run() {
        System.out.println("Start riding");
        for(int i=0;i<path.length;i++) {
            try {
                current = path[i];
                takeStation(path[i]);
                //time to take and release passangers
                sleep(2_000);
                leaveStation();
                //time to get next station
                sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println(e.getCause());
            }
        }
        System.out.println("The last station");
    }
}
