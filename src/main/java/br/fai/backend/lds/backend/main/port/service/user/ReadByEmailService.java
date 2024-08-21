package br.fai.backend.lds.backend.main.port.service.user;

import br.fai.backend.lds.backend.main.domain.UserModel;

public interface ReadByEmailService {

    UserModel findByEmail(final String email);
}
