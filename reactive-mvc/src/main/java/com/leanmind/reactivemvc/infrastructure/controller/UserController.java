package com.leanmind.reactivemvc.infrastructure.controller;

import com.leanmind.reactivemvc.application.user_creator.CreateUserRequestDto;
import com.leanmind.reactivemvc.application.user_creator.UserCreator;
import com.leanmind.reactivemvc.application.user_finder_by_email.UserFinderByEmail;
import com.leanmind.reactivemvc.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserCreator userCreator;
    private final UserFinderByEmail userFinderByEmail;

    public UserController(UserCreator userCreator, UserFinderByEmail userFinderByEmail) {
        this.userCreator = userCreator;
        this.userFinderByEmail = userFinderByEmail;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto userDto) {
        userCreator.execute(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Mono<User>> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userFinderByEmail.execute(email));
    }
}
