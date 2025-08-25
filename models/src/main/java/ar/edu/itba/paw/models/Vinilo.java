package ar.edu.itba.paw.models;

import java.util.Date;

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

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getEstadoPublicacion() {
        return estadoPublicacion;
    }

    public Integer getStock() {
        return stock;
    }

    public Date getCreadoEn() {
        return creadoEn;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public void setEstadoPublicacion(String estadoPublicacion) {
        this.estadoPublicacion = estadoPublicacion;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
}