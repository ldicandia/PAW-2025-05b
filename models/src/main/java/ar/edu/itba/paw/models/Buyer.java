package ar.edu.itba.paw.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Buyer {
    private final long id;
    private final String name;
    private final String dni;
    private final String email;

    public Buyer(final long id, final String name, final String dni, final String email) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.email = email;
    }
}
