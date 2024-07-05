package com.leanmind.mvc.infrastructure.controller;

import com.leanmind.mvc.application.all_users_finder.AllUsersFinder;
import com.leanmind.mvc.application.user_creator.CreateUserRequestDto;
import com.leanmind.mvc.application.user_creator.UserCreator;
import com.leanmind.mvc.application.user_finder_by_email.UserFinderByEmail;
import com.leanmind.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserCreator userCreator;
    private final UserFinderByEmail userFinderByEmail;
    private final AllUsersFinder allUsersFinder;

    public UserController(UserCreator userCreator, UserFinderByEmail userFinderByEmail, AllUsersFinder allUsersFinder) {
        this.userCreator = userCreator;
        this.userFinderByEmail = userFinderByEmail;
        this.allUsersFinder = allUsersFinder;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto userDto) {
        userCreator.execute(userDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return userFinderByEmail.execute(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(allUsersFinder.execute());
    }
}
