package ar.edu.itba.paw.models;

public class Comprador {
    private final long id;
    private final String nombre;
    private final String apellido;
    private final String email;

    public Comprador(final long id, final String nombre, final String apellido, final String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }
}
