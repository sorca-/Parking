package by.boika.parking.main;

import by.boika.parking.model.InitRun;

public class Main {
    public static void main(String[] args) {
        int countOfCars = 10;
        int countOfParking = 3;
        int seatsOnParking = 3;
        InitRun.init(countOfCars, countOfParking, seatsOnParking);
    }
}
