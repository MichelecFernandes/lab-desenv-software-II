package br.fai.backend.lds.backend.main.service.user;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.service.crud.CrudService;
import br.fai.backend.lds.backend.main.port.service.user.UpdatePasswordService;

import java.util.List;

public class UserServiceImpl implements CrudService<UserModel>, UpdatePasswordService {


    @Override
    public int create(UserModel entity) {
        return 0;
    }
    @Override
    public void delete(int id){

    }

    @Override
    public UserModel findById(int id) {
        return null;
    }

    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public void update(int id, UserModel entity) {

    }

    @Override
    public boolean updatePassword(int id, String oldPassword, String newPassword) {
        return false;
    }
}
