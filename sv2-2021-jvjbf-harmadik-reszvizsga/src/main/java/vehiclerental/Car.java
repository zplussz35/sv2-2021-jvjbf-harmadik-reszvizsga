package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable{

    private String carId;
    private LocalTime rentingTime;
    private int rentingFeePerMin;

    public Car(String carId, int rentingFeePerMin) {
        this.carId = carId;
        this.rentingFeePerMin = rentingFeePerMin;
    }

    @Override
    public int calculateSumPrice(int minutes) {
        return rentingFeePerMin*minutes;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        rentingTime=time;

    }

    @Override
    public void closeRent() {
        rentingTime=null;
    }
}
