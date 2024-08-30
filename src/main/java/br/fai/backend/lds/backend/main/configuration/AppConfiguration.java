package br.fai.backend.lds.backend.main.configuration;

import br.fai.backend.lds.backend.main.dao.fake.UserFakeDaoImpl;
import br.fai.backend.lds.backend.main.dao.h2.UserH2DaoImpl;
import br.fai.backend.lds.backend.main.port.dao.user.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration

public class AppConfiguration {
    @Bean
    @Profile("fake")
    public UserDao getUserFakeDao(){
        return new UserFakeDaoImpl();
    }
    @Bean
    @Profile("dev")
    public UserDao getH2Dao(final JdbcTemplate jdbcTemplate){
        return new UserH2DaoImpl(jdbcTemplate);
    }


}
