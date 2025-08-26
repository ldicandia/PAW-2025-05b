package ar.edu.itba.paw.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Vinilo {
    private long id;
    private String nombre;
    private Date fechaLanzamiento;
    private String genero;
    private Float precio;
    private String condicion;
    private String estadoPublicacion;
    private Integer stock;
    private Date creadoEn;

    public Vinilo(long id, String nombre, Date fechaLanzamiento, String genero, Float precio,
                  String condicion, String estadoPublicacion, Integer stock, Date creadoEn) {
        this.id = id;
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.precio = precio;
        this.condicion = condicion;
        this.estadoPublicacion = estadoPublicacion;
        this.stock = stock;
        this.creadoEn = creadoEn;
    }
}