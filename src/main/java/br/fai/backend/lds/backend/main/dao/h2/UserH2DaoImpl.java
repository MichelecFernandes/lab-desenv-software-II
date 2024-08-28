package br.fai.backend.lds.backend.main.dao.h2;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class UserH2DaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserH2DaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(UserModel entity) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user_model").usingGeneratedKeyColumns("id");
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("email: ", entity.getEmail());
        parameters.put("password: ", entity.getPassword());
        parameters.put("fullName: ", entity.getFullName());

        final Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        return 0;
    }

    @Override
    public void remove(int id) {
        final String sql = "DELETE FROM user_model WHERE id = "+ id;
        jdbcTemplate.execute(sql);

    }

    @Override
    public UserModel readyById(int id) {
        return null;
    }

    @Override
    public List<UserModel> readAll() {
        return null;
    }

    @Override
    public void updateInformation(int id, UserModel entity) {

    }

    @Override
    public UserModel readByEmail(String email) {
        return null;
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        return false;
    }
}
