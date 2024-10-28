package br.fai.backend.lds.backend.main.port.service.authentication;

import br.fai.backend.lds.backend.main.domain.UserModel;

public interface AuthenticationService {
    UserModel authenticate(final String email, final String password);

}
