package javacore.padroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final Set<String> availableSeats = new HashSet<>();
    private String number;
    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public Aircraft(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }
}
