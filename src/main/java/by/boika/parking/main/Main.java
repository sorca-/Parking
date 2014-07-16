package by.boika.parking.main;

import by.boika.parking.model.Car;
import by.boika.parking.model.InitRun;
import by.boika.parking.model.Parking;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int countOfCars = 10;
        int countOfParking = 3;
        int seatsOnParking = 3;
        InitRun.init(countOfCars, countOfParking, seatsOnParking);
    }
}
