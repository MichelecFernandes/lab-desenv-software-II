package br.fai.backend.lds.backend.main.security;

import br.fai.backend.lds.backend.main.domain.UserModel;
import br.fai.backend.lds.backend.main.port.service.authentication.AuthenticationService;

import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Profile("sec")
@RestController()
public class AuthenticationController {

    private  final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserModel> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();

        UserModel authenticatedUser = authenticationService.authenticate(email, password);

        if(authenticatedUser == null){
            throw new BadCredentialsException("Email ou senha invalidos");
        }
        return ResponseEntity.ok(authenticatedUser);
    }
}
