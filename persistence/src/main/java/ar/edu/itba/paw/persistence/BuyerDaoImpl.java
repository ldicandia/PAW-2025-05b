package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BuyerDaoImpl implements BuyerDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    private static final RowMapper<Buyer> ROW_MAPPER =
            (rs, rowNum) -> new Buyer(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("dni"),
                    rs.getString("email"));

    @Autowired
    public BuyerDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("buyer");
    }

    @Override
    public Buyer create(String name, String email, String dni) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", name);
        parameters.put("email", email);
        parameters.put("dni", dni);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Buyer(id.longValue(), name, dni, email);
    }

    @Override
    public Optional<Buyer> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM buyer WHERE id = ?", ROW_MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Buyer> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM buyer WHERE email = ?", ROW_MAPPER, email)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Buyer> findByDni(String dni) {
        return jdbcTemplate.query("SELECT * FROM buyer WHERE dni = ?", ROW_MAPPER, dni)
                .stream()
                .findFirst();
    }
}
