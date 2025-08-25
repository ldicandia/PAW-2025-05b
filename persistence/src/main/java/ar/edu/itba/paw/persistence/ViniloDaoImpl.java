package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Cancion;
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
public class ViniloDaoImpl implements ViniloDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    private static final RowMapper<Vinilo> ROW_MAPPER = (rs, rowNum) -> new Vinilo(
            rs.getLong("id"),
            rs.getString("nombre"),
            rs.getDate("fecha_lanzamiento"),
            rs.getString("genero"),
            rs.getFloat("precio"),
            rs.getString("condicion"),
            rs.getString("estado_publicacion"),
            rs.getInt("stock"),
            rs.getDate("creado_en")
    );

    @Autowired
    public ViniloDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("vinilo");
    }

    @Override
    public Vinilo create(String nombre, String fecha_lanzamiento, String genero, Cancion[] canciones,
                         float precio, String condicion, Integer stock) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", nombre);
        parameters.put("fecha_lanzamiento", java.sql.Date.valueOf(fecha_lanzamiento));
        parameters.put("genero", genero);
        parameters.put("precio", precio);
        parameters.put("condicion", condicion);
        parameters.put("estado_publicacion", "activa");
        parameters.put("stock", stock);
        parameters.put("creado_en", new java.sql.Date(System.currentTimeMillis()));
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Vinilo(id.longValue(), nombre, java.sql.Date.valueOf(fecha_lanzamiento), genero,
                precio, condicion, "Nuevo", stock, new java.sql.Date(System.currentTimeMillis()));
    }

    @Override
    public Optional<Vinilo> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM vinilo WHERE id = ?", ROW_MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Vinilo> findAll() {
        return jdbcTemplate.query("SELECT * FROM vinilo", ROW_MAPPER);
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM vinilo WHERE id = ?", id);
    }
}



