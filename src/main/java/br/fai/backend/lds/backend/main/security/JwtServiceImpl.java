package br.fai.backend.lds.backend.main.security;

import br.fai.backend.lds.backend.main.domain.UserModel;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public class JwtServiceImpl implements JwtService{
    @Override
    public String getEmailFromToken(String token) {
        return null;
    }

    @Override
    public Date getExpirationFromToken(String token) {
        return null;
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        return null;
    }

    @Override
    public Claims getAllClaimsFromToken(String token) {
        return null;
    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String generateToken(UserDetails userDetails, String fullName, UserModel.UserRole role, String email) {
        return null;
    }

    @Override
    public String createToken(Map<String, Object> claims, String subject) {
        return null;
    }
}
