package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {
    private Set<User> users = new HashSet<>();
    private Set<Rentable> vehicles = new HashSet<>();
    private Map<Rentable, User> rents = new TreeMap<>();

    public void registerUser(User user) {
        if (users.contains(user)) {
            throw new UserNameIsAlreadyTakenException("Username is taken!");
        }
        users.add(user);
    }

    public void addRentable(Rentable rentable) {
        vehicles.add(rentable);
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
        if (time.getMinute() <= 180) {
            if (rentable.getRentingTime() == null) {
                if (user.getBalance() >= rentable.calculateSumPrice(time.getMinute())) {
                    rentable.rent(time);
                    rents.put(rentable, user);
                } else {
                    throw new IllegalStateException("Dont have enough money!");
                }

            } else {
                throw new IllegalStateException("Cannot rent!");
            }

        } else {
            throw new IllegalStateException("max rentingtime is 3 hours!");
        }
    }

    public void closeRent(Rentable rentable, int minutes) {
        if (rents.containsKey(rentable)) {

            rents.get(rentable).minusBalance(rentable.calculateSumPrice(minutes));
            rents.remove(rentable);
            rentable.closeRent();
        } else {
            throw new IllegalStateException("Dont contains this rent!");
        }
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Rentable> getRentables() {
        return vehicles;
    }

    public Map<Rentable, User> getActualRenting() {
        return rents;
    }


}
