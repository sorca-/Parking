package by.boika.parking.model;

import org.apache.log4j.Logger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking{

    private int id;
    private Semaphore semaphore;
    private final static Logger LOGGER = Logger.getLogger(Parking.class.getName());

    public Parking(int countOfSeats, int id) {
        this.id = id;
        semaphore = new Semaphore(countOfSeats, false);
    }

    public boolean tryPark(int waitTime) {
        try {
            if (semaphore.tryAcquire(waitTime, TimeUnit.MILLISECONDS))
            {
                return true;
            }
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    //    public void leaveParking () {
//        semaphore.release();
//    }
//    public void addSeats (int count) {
//        semaphore.release();
//    }
//    public boolean removeSeats (int count) {
//        boolean flag = false;
//        try {
//            semaphore.acquire();
//            flag = true;
//        } catch (InterruptedException e) {
//            LOGGER.error(e);
//        }
//        return flag;
//    }
}
