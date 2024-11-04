package br.fai.backend.lds.backend.main.service.authentication;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.service.authentication.AuthenticationService;
import br.fai.backend.lds.backend.main.port.service.user.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BasicAuthenticationServiceImpl implements AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public BasicAuthenticationServiceImpl(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserModel authenticate(String email, String password){
        UserModel userModel = userService.findByEmail(email);
        if(userModel == null){
            throw new UsernameNotFoundException("Credenciais inválidas");
        }
        //if de comparação antigo - nao usar após encriptar a senha
        //if(!userModel.getPassword().equals((password))){
        //    return null;
        //}

        // if que deve ser utilizado ao estar encriptando a senha
        if(!passwordEncoder.matches(password, userModel.getPassword())){
            throw new BadCredentialsException("Credenciais inválidas");
        }
        return userModel;
    }



}
