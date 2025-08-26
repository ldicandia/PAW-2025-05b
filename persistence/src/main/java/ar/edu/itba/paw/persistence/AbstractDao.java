package ar.edu.itba.paw.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Optional;
@Repository
public abstract class AbstractDao<T> {

    protected final JdbcTemplate jdbcTemplate;
    protected final SimpleJdbcInsert jdbcInsert;
    private final RowMapper<T> rowMapper;
    private final String tableName;
    private final String generatedKeyColumn;

    @Autowired
    protected AbstractDao(DataSource dataSource, String tableName, String generatedKeyColumn, RowMapper<T> rowMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns(generatedKeyColumn)
                .withTableName(tableName);
        this.rowMapper = rowMapper;
        this.tableName = tableName;
        this.generatedKeyColumn = generatedKeyColumn;
    }

    public Optional<T> findById(long id) {
        String query = String.format("SELECT * FROM %s WHERE %s = ?", tableName, generatedKeyColumn);
        return jdbcTemplate.query(query, rowMapper, id).stream().findFirst();
    }

    public T create(Map<String, Object> values) {
        Number key = jdbcInsert.executeAndReturnKey(values);
        return findById(key.longValue()).orElseThrow(() -> new IllegalStateException("Entity not found after creation"));
    }
}