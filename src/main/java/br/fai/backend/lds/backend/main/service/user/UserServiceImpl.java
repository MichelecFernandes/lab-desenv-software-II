package br.fai.backend.lds.backend.main.service.user;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;
import br.fai.backend.lds.backend.main.port.service.crud.UpdateService;
import br.fai.backend.lds.backend.main.port.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public int create(UserModel entity) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public List<UserModel> findAll() {
        System.out.println("find all foi chamdao");
        List<UserModel> users = userDao.readAll();
        return users;
    }

    @Override
    public void update(int id, UserModel entity) {

    }

    @Override
    public UserModel findByEmail(String email) {
            return null;
    }

    @Override
    public boolean updatePassword(int id, String oldPassword, String newPassword) {
        return false;
    }
}
