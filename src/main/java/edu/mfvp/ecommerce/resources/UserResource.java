package edu.mfvp.ecommerce.resources;

import edu.mfvp.ecommerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User(1L,"Matheus", "matheus@gmail.com", "15998789657", "123456");
        return ResponseEntity.ok(user);
    }
}
