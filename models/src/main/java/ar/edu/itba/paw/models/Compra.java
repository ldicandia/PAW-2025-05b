package ar.edu.itba.paw.models;

public class Compra {
    private final long id;
    private final Comprador comprador;
    private final Vinilo vinilo;

    public Compra(final long id, final Comprador comprador, Vinilo vinilo) {
        this.id = id;
        this.comprador = comprador;
        this.vinilo = vinilo;
    }

    public long getId() {
        return id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Vinilo getVinilo() {
        return vinilo;
    }
}
