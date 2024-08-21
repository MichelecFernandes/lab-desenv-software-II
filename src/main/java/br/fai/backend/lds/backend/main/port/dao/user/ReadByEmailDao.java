package br.fai.backend.lds.backend.main.port.dao.user;

import br.fai.backend.lds.backend.main.domain.UserModel;

public interface ReadByEmailDao {
    UserModel readByEmail(final String email);
}
