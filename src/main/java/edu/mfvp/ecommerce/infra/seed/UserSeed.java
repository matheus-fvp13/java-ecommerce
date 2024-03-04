package edu.mfvp.ecommerce.infra.seed;

import edu.mfvp.ecommerce.infra.database.entities.UserEntity;
import edu.mfvp.ecommerce.infra.database.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class UserSeed implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserSeed(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity(null, "Matheus Vieira", "mfvp@gmail.com", "(15)11234-8978", "1234");
        UserEntity user2 = new UserEntity(null, "Paula Oliveira", "paula@gmail.com", "(15)11134-9978", "1254");
        userRepository.saveAll(List.of(user1, user2));
    }
}
