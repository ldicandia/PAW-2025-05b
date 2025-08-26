package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.Buyer;
import ar.edu.itba.paw.models.Song;
import ar.edu.itba.paw.models.Vinyl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
public class SongDaoImpl implements SongDao {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    private static final RowMapper<Song> ROW_MAPPER =
            (rs, rowNum) -> new Song(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("artist"),
                    rs.getInt("durationsec"),
                    rs.getInt("position"),
                    rs.getLong("vinylid")
            );

    public SongDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .usingGeneratedKeyColumns("id")
                .withTableName("song");
    }

    @Override
    public Song create(String title, String artist, int durationSec, int position, long vinylId) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", title);
        parameters.put("artist", artist);
        parameters.put("durationsec", durationSec);
        parameters.put("position", position);
        parameters.put("vinylid", vinylId);
        Number id = jdbcInsert.executeAndReturnKey(parameters);
        return new Song(id.longValue(), title, artist, durationSec, position, vinylId);
    }

    @Override
    public Optional<Song> findById(long id) {
        return jdbcTemplate.query("SELECT * FROM song WHERE id = ?", ROW_MAPPER, id)
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Song> findByTitle(String title) {
        return jdbcTemplate.query("SELECT * FROM song WHERE title = ?", ROW_MAPPER, title)
                .stream()
                .findFirst();
    }
}
