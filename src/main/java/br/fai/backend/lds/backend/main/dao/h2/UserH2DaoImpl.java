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

        System.out.println("Ganhei uma instancia do UserH2Dao");
    }

    @Override
    public int add(UserModel entity) {
        final SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user_model").usingGeneratedKeyColumns("id");
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("email: ", entity.getEmail());
        parameters.put("password: ", entity.getPassword());
        parameters.put("fullName: ", entity.getFullName());
        parameters.put("role", entity.getRole().name());

        final Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        return id.intValue();
    }

    @Override
    public void remove(int id) {
        final String sql = "DELETE FROM user_model WHERE id = "+ id;
        jdbcTemplate.execute(sql);

    }

    @Override
    public UserModel readyById(int id) {
        final UserModel entity = jdbcTemplate.queryForObject("SELECT * FROM user_model WHERE id = ", new Object[]{id},(rs,rowNum) ->
                new UserModel(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        UserModel.UserRole.valueOf(rs.getString("role"))

                ));
        return entity;
    }

    @Override
    public List<UserModel> readAll() {
        final List<UserModel> entities = jdbcTemplate.query("SELECT * FROM user_model", new Object[]{},(rs,rowNum) ->
                new UserModel(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        UserModel.UserRole.valueOf(rs.getString("role"))

                ));

        return entities;
    }

    @Override
    public void updateInformation(int id, UserModel entity) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE user_model SET");
        stringBuilder.append(" fullName = ? ");
        stringBuilder.append(" WHERE id = ? ");
        jdbcTemplate.update(stringBuilder.toString(), entity.getFullName(),id);

    }

    @Override
    public UserModel readByEmail(String email) {
        final UserModel entity = jdbcTemplate.queryForObject("SELECT * FROM user_model WHERE email = ?", new Object[]{email},(rs,rowNum) ->
                new UserModel(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("fullName"),
                        UserModel.UserRole.valueOf(rs.getString("role"))

                ));
        return entity;
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE user_model SET");
        stringBuilder.append(" password = ? ");
        stringBuilder.append(" WHERE id = ? ");
        final int updateItems = jdbcTemplate.update(stringBuilder.toString(), newPassword,id);
        return updateItems != 0;

    }
}
