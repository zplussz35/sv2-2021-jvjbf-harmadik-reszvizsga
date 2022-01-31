package vehiclerental;

import java.time.LocalTime;

public class Bike implements Rentable{

    private String bikeId;
    private LocalTime rentingTime;

    public Bike(String bikeId) {
        this.bikeId = bikeId;
    }

    @Override
    public int calculateSumPrice(int minutes) {
        return 15*minutes;
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
