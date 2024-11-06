package br.fai.backend.lds.backend.main.security;

import br.fai.backend.lds.backend.main.domain.UserModel;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String getEmailFromToken(String token);

    Date getExpirationFromToken(String token);

    //<T> é o Generics
    //Claims vem de um a dependencia de terceiros
    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    Claims getAllClaimsFromToken(String token);

    boolean isTokenExpired(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    ///Esse metodo que eu injeto no token todas as informações do usuario
    String generateToken(final UserDetails userDetails,
                         final String fullName,
                         final UserModel.UserRole role,
                         final String email);

    String createToken(Map<String, Object> claims, String subject);
}
