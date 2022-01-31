package vehiclerental;

import java.time.LocalTime;

public interface Rentable extends Comparable<Rentable> {
    int calculateSumPrice(int minutes);
    LocalTime getRentingTime();
    void rent(LocalTime time);
    void closeRent();

    @Override
    default int compareTo(Rentable o){
        return getRentingTime().compareTo(o.getRentingTime());
    }
}
