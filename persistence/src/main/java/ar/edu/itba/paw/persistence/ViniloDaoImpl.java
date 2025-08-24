package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Cancion;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.models.Vinilo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ViniloDaoImpl implements ViniloDao{
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;
    private static final RowMapper<Vinilo> ROW_MAPPER =
            (rs, rowNum) -> new Vinilo.Builder()
                    .id(rs.getLong("id"))
                    .nombre(rs.getString("nombre"))
                    .fechaLanzamiento(rs.getDate("fecha_lanzamiento"))
                    .genero(rs.getString("genero"))
                    .precio(rs.getFloat("precio"))
                    .condicion(rs.getString("condicion"))
                    .estadoPublicacion(rs.getString("estado_publicacion"))
                    .creadoEn(rs.getDate("creado_en"))
                    .stock(rs.getInt("stock"))
                    .build();
    @Autowired
    public ViniloDaoImpl(final DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("vinilo");
    }
    @Override
    public Vinilo create(String nombre, String fecha_lanzamiento, String genero, Cancion[] canciones, float precio, String condicion, Integer stock) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", nombre);
        parameters.put("fecha_lanzamiento", java.sql.Date.valueOf(fecha_lanzamiento));
        parameters.put("genero", genero);
        parameters.put("precio", precio);
        parameters.put("condicion", condicion);
        parameters.put("estado_publicacion", "Nuevo");
        parameters.put("stock", stock);
        parameters.put("creado_en", new java.sql.Date(System.currentTimeMillis()));
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Vinilo.Builder()
                .id(id.longValue())
                .nombre(nombre)
                .fechaLanzamiento(java.sql.Date.valueOf(fecha_lanzamiento))
                .genero(genero)
                .precio(precio)
                .condicion(condicion)
                .estadoPublicacion("Nuevo")
                .stock(stock)
                .creadoEn(new java.sql.Date(System.currentTimeMillis()))
                .build();
    }
    @Override
    public List<Vinilo> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM vinilo WHERE id = ? ",ROW_MAPPER, id );
    }
}
