package ar.edu.itba.paw.persistence;

import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User create(long id, String username) {
        return new User(id, username);
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.empty();
    }

//    private static final RowMapper<User> USER_MAPPER = (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("username"));
//
//    @Override
//    public Optional<User> findById(long id) {
//        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE id = " + new Object[] {id}, USER_MAPPER);
//        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
//    }
//
//    public Optional<User> findByUsername(String username) {
//        List<User> users = jdbcTemplate.query("SELECT * FROM users WHERE username = " + new Object[] {username}, USER_MAPPER);
//        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
//    }


}
