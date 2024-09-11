package br.fai.backend.lds.backend.main.dao.postgress;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class UserPostgresDaoImpl implements UserDao {


    // Adicionar a linha 14 em todas as classes, substitui o SOUT
    private static final Logger logger = Logger.getLogger(UserPostgresDaoImpl.class.getName());

    // Quem faz a connection é o spring
    private final Connection connection;

    public UserPostgresDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(UserModel entity) {

        String sql = "INSERT INTO user_model(password, fullname, email) ";
        sql += " VALUES(?, ?, ?);";

        // Quem faz a connection é o spring
        // Connection connection;

        // Preapara a chamada da sql
        PreparedStatement preparedStatement;
        // Assim que eu fizer a inserção, eu preciso receber o retorno que deu bom, ai ele me passa o id
        ResultSet resultSet;

        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entity.getPassword());
            preparedStatement.setString(2, entity.getFullName());
            preparedStatement.setString(3, entity.getEmail());

            preparedStatement.execute();

            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                final int id = resultSet.getInt(1);
                entity.setId(id);

            }

            connection.commit();

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            throw new RuntimeException(e);
        }


        return entity.getId();
    }

    @Override
    public void remove(int id) {

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
