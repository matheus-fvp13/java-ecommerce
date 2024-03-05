package edu.mfvp.ecommerce.infra.seed;

import edu.mfvp.ecommerce.domain.enums.OrderStatus;
import edu.mfvp.ecommerce.infra.database.entities.CategoryEntity;
import edu.mfvp.ecommerce.infra.database.entities.OrderEntity;
import edu.mfvp.ecommerce.infra.database.entities.UserEntity;
import edu.mfvp.ecommerce.infra.database.repositories.CategoryRepository;
import edu.mfvp.ecommerce.infra.database.repositories.OrderRepository;
import edu.mfvp.ecommerce.infra.database.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.swing.text.html.parser.Entity;
import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class UserSeed implements CommandLineRunner {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;

    public UserSeed(UserRepository userRepository,
                    OrderRepository orderRepository,
                    CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");

        categoryRepository.saveAll(List.of(cat1, cat2, cat3));

        UserEntity user1 = new UserEntity(null, "Matheus Vieira", "mfvp@gmail.com", "(15)11234-8978", "1234");
        UserEntity user2 = new UserEntity(null, "Paula Oliveira", "paula@gmail.com", "(15)11134-9978", "1254");

        OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED.getCode(), user1);
        OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID.getCode(), user2);
        OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT.getCode(), user1);

        userRepository.saveAll(List.of(user1, user2));
        orderRepository.saveAll(List.of(o1, o2, o3));
    }
}
