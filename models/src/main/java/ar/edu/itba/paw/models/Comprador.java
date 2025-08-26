package ar.edu.itba.paw.models;


import lombok.Getter;

@Getter
public class Comprador {
    private final long id;
    private final String nombre;
    private final String dni;
    private final String email;

    public Comprador(final long id, final String nombre, final String  dni, final String email) {
        this.id = id;
        this.nombre = nombre;
        this. dni =  dni;
        this.email = email;
    }
}
