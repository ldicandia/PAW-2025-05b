package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.models.Vinyl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class VinylDaoImpl implements VinylDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    private static final RowMapper<Vinyl> ROW_MAPPER = (rs, rowNum) -> new Vinyl(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getDate("releasedate"),
            rs.getString("genre"),
            rs.getFloat("price"),
            rs.getString("condition"),
            rs.getString("publicationstatus"),
            rs.getInt("stock"),
            rs.getDate("createdat")
    );

    @Autowired
    public VinylDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("vinyl");
    }

    @Override
    public Vinyl create(String title, Date releaseDate, String genre, Float price, String condition, String publicationStatus, Integer stock, Date createdOn) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", title);
        parameters.put("releasedate", java.sql.Date.valueOf(String.valueOf(releaseDate)));
        parameters.put("genre", genre);
        parameters.put("price", price);
        parameters.put("condition", condition);
        parameters.put("publicationstatus", "active");
        parameters.put("stock", stock);
        parameters.put("createdat", new java.sql.Date(System.currentTimeMillis()));
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Vinyl(id.longValue(), title, java.sql.Date.valueOf(String.valueOf(releaseDate)), genre,
                price, condition, "New", stock, new java.sql.Date(System.currentTimeMillis()));
    }

    @Override
    public Optional<Vinyl> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM vinyl WHERE id = ?", ROW_MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Vinyl> findAll() {
        return jdbcTemplate.query("SELECT * FROM vinyl", ROW_MAPPER);
    }
}