package by.boika.parking.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Car extends Thread {

    private final static Logger LOGGER = Logger.getLogger(Car.class.getName());
    private int waitTime;
    private ArrayList<Parking> parkingList;

    public Car(String name, int waitTime, ArrayList<Parking> parkingList) {
        super(name);
        this.parkingList = parkingList;
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        try {
            boolean parkFlag = false;
            for (Parking parking : parkingList) {
                long timeToRoad = Math.round((1+Math.random())*5000);
                LOGGER.info(Thread.currentThread().getName() + ": go to the parking #" + parking);
                Thread.sleep(timeToRoad);
                parkFlag = parking.tryPark(waitTime);
                if (parkFlag) {
                    LOGGER.info(Thread.currentThread().getName() + ": stay on parking #" + parking);
                    break;
                } else {
                    LOGGER.info(Thread.currentThread().getName() + ": parking time out.");
                }
            }

            if (!parkFlag) {
                LOGGER.info("No places. Go to the home.");
            }
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }

//    public void setWaitTime(int waitTime) {
//        this.waitTime = waitTime;
//    }
//
//    public int getWaitTime() {
//        return waitTime;
//    }
//
//    public void addParking (Parking parking) {
//        if (parking != null) {
//            parkingList.add(parking);
//        }
//    }
}
