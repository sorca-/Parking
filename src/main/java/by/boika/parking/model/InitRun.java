package by.boika.parking.model;

import java.util.ArrayList;

public class InitRun {
    public static void init(int countCars, int countParking, int seatsOnParking) {
        int kWaitingTime = 100;
        ArrayList<Parking> parkingList = new ArrayList<Parking>();
        for (int i = 0; i < countParking; i++) {
            parkingList.add(new Parking(seatsOnParking, i));
        }
        for (int i = 0; i < countCars; i++) {
            Car car = new Car(String.valueOf(i), i*kWaitingTime, parkingList);
            new Thread(car).start();
        }
    }
}
