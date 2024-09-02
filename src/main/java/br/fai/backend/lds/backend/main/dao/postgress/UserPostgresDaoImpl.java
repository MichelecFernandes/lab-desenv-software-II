package br.fai.backend.lds.backend.main.dao.postgress;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserPostgresDaoImpl implements UserDao {


    // Adicionar a linha 14 em todas as classes, substitui o SOUT
    private static final Logger logger = Logger.getLogger(UserPostgresDaoImpl.class.getName());

    @Override
    public int add(UserModel entity) {
        logger.log(Level.SEVERE, "perigo");
        return 0;
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
