package ar.edu.itba.paw.models;

import lombok.Getter;

import java.util.Date;


@Getter
public class Compra {
    private final long id;
    private final Comprador comprador;
    private final Vinilo vinilo;
    private final String estado;
    private final Float precio;
    private final Date creadaEn;
    private final Date pagadaEn;
    private final Date pagoRecibidoEn;
    private final Date enviadaEn;
    private final Date entregadaEn;

    public Compra(long id, Comprador comprador, Vinilo vinilo, String estado, Float precio, Date creadaEn, Date pagadaEn, Date pagoRecibidoEn, Date enviadaEn, Date entregadaEn) {
        this.id = id;
        this.comprador = comprador;
        this.vinilo = vinilo;
        this.estado = estado;
        this.precio = precio;
        this.creadaEn = creadaEn;
        this.pagadaEn = pagadaEn;
        this.pagoRecibidoEn = pagoRecibidoEn;
        this.enviadaEn = enviadaEn;
        this.entregadaEn = entregadaEn;
    }

}