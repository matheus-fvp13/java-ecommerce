package edu.mfvp.ecommerce.config;

import edu.mfvp.ecommerce.entities.User;
import edu.mfvp.ecommerce.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Matheus Vieira", "mfvp@gmail.com", "(15)11234-8978", "1234");
        User user2 = new User(null, "Paula Oliveira", "paula@gmail.com", "(15)11134-9978", "1254");
        userRepository.saveAll(List.of(user1, user2));
    }
}
