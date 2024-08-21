package br.fai.backend.lds.backend.main.port.service.user;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.service.crud.CrudService;

public interface UserService extends CrudService<UserModel>, UpdatePasswordService, ReadByEmailService{

}
