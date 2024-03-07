package edu.mfvp.ecommerce.application.web.resources;

import edu.mfvp.ecommerce.application.services.UserService;
import edu.mfvp.ecommerce.application.web.request.UserCreateRequest;
import edu.mfvp.ecommerce.application.web.request.UserUpdateRequest;
import edu.mfvp.ecommerce.application.web.response.UserResponse;
import edu.mfvp.ecommerce.domain.entities.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> users = userService.findAll().stream()
                .map(UserResponse::toUserResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(UserResponse.toUserResponse(userService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserCreateRequest userCreateRequest, UriComponentsBuilder ucb) {
        User user = userService.create(userCreateRequest.toUser());
        URI locationOfNewUser = ucb
                .path("/users/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewUser).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest userRequest) {
        return ResponseEntity.ok(UserResponse.toUserResponse(userService.update(id, userRequest.toUser())));
    }
}
