package ar.edu.itba.paw.models;

import java.util.Date;

public class Vinilo {
    private final long id;
    private final String nombre;
    private final Date fecha_lanzamiento;
    private final String genero;
    private final Float precio;
    private final String condicion;
    private final String estado_publicacion;
    private final Integer stock;
    private final Date creado_en;

    private Vinilo(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.fecha_lanzamiento = builder.fecha_lanzamiento;
        this.genero = builder.genero;
        this.precio = builder.precio;
        this.condicion = builder.condicion;
        this.estado_publicacion = builder.estado_publicacion;
        this.stock = builder.stock;
        this.creado_en = builder.creado_en;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
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

    public String getEstado_publicacion() {
        return estado_publicacion;
    }

    public Integer getStock() {
        return stock;
    }

    public Date getCreado_en() {
        return creado_en;
    }

    public static class Builder {
        private long id;
        private String nombre;
        private Date fecha_lanzamiento;
        private String genero;
        private Float precio;
        private String condicion;
        private String estado_publicacion;
        private Integer stock;
        private Date creado_en;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder fechaLanzamiento(Date fecha_lanzamiento) {
            this.fecha_lanzamiento = fecha_lanzamiento;
            return this;
        }

        public Builder genero(String genero) {
            this.genero = genero;
            return this;
        }

        public Builder precio(Float precio) {
            this.precio = precio;
            return this;
        }

        public Builder condicion(String condicion) {
            this.condicion = condicion;
            return this;
        }

        public Builder estadoPublicacion(String estado_publicacion) {
            this.estado_publicacion = estado_publicacion;
            return this;
        }

        public Builder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public Builder creadoEn(Date creado_en) {
            this.creado_en = creado_en;
            return this;
        }

        public Vinilo build() {
            return new Vinilo(this);
        }
    }


}