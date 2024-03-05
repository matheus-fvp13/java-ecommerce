package edu.mfvp.ecommerce.infra.seed;

import edu.mfvp.ecommerce.domain.entities.Payment;
import edu.mfvp.ecommerce.domain.enums.OrderStatus;
import edu.mfvp.ecommerce.infra.database.entities.*;
import edu.mfvp.ecommerce.infra.database.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.swing.text.html.parser.Entity;
import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class UserSeed implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");

        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(List.of(cat1, cat2, cat3));
        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().addAll(List.of(cat1, cat3));
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(List.of(p1, p2, p3, p4, p5));

        UserEntity user1 = new UserEntity(null, "Matheus", "Vieira", "mfvp@gmail.com", "(15)11234-8978", "1234");
        UserEntity user2 = new UserEntity(null, "Paula", "Oliveira", "paula@gmail.com", "(15)11134-9978", "1254");

        OrderEntity o1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT.getCode(), user1);
        OrderEntity o2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID.getCode(), user2);
        OrderEntity o3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT.getCode(), user1);

        userRepository.saveAll(List.of(user1, user2));
        orderRepository.saveAll(List.of(o1, o2, o3));

        OrderItemEntity oi1 = new OrderItemEntity(o1, p1, 2, p1.getPrice());
        OrderItemEntity oi2 = new OrderItemEntity(o1, p3, 1, p3.getPrice());
        OrderItemEntity oi3 = new OrderItemEntity(o2, p3, 2, p3.getPrice());
        OrderItemEntity oi4 = new OrderItemEntity(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(List.of(oi1, oi2, oi3, oi4));

        PaymentEntity payment = new PaymentEntity(null, Instant.parse("2019-07-21T05:42:10Z"), o2);
        o2.setPayment(payment);
        orderRepository.save(o2);
    }
}
