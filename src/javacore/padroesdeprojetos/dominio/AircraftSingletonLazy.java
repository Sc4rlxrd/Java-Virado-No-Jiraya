package javacore.padroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    // Lazy Initialization ⇾ adia a criação de um objeto ou a realização de uma operação até que seja realmente necessário diferente do Eager Initialization toda a vez que usa cria uma instância nova.
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public AircraftSingletonLazy(String name) {
        this.name = name;
    }

    public static AircraftSingletonLazy getInstance() {
        if (INSTANCE == null) {
            // Lembrando essa dica só serve no projeto com multithreading.
            // Double lock → esse metodo seria mais recomendado que usar o synchronized no metodo devido ao processamento.
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {

                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;

    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

}
