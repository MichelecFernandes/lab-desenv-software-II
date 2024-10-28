package br.fai.backend.lds.backend.main.configuration;

import br.fai.backend.lds.backend.main.dao.fake.UserFakeDaoImpl;
import br.fai.backend.lds.backend.main.dao.h2.UserH2DaoImpl;
import br.fai.backend.lds.backend.main.dao.postgress.UserPostgresDaoImpl;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;
import br.fai.backend.lds.backend.main.port.service.authentication.AuthenticationService;
import br.fai.backend.lds.backend.main.port.service.user.UserService;
import br.fai.backend.lds.backend.main.service.authentication.BasicAuthenticationServiceImpl;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

@Configuration

public class AppConfiguration {
    @Bean
    @Profile("fake")
    public UserDao getUserFakeDao() {
        return new UserFakeDaoImpl();
    }

    @Bean
    @Profile("dev")
    public UserDao getH2Dao(final JdbcTemplate jdbcTemplate) {
        return new UserH2DaoImpl(jdbcTemplate);
    }

    @Bean
    @Profile({"prod", "sec"})
    public UserDao getUserDao(final Connection connection) {
        return new UserPostgresDaoImpl(connection);
    }

    @Bean
    @Profile("prod")
    public AuthenticationService getAuthenticationService(UserService userService){
        return new BasicAuthenticationServiceImpl(userService);
    }


    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info().
                title("LDS").
                version("1.0.0").
                description("LDS API"));
    }

}
