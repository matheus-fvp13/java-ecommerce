package edu.mfvp.ecommerce.application.config;

import edu.mfvp.ecommerce.application.gateways.UserGateway;
import edu.mfvp.ecommerce.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    UserService createUserService(UserGateway userGateway) {
        return new UserService(userGateway);
    }
}
