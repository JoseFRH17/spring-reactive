package com.leanmind.reactivemvc.infrastructure.controller;

import com.leanmind.reactivemvc.application.user_creator.CreateUserRequestDto;
import com.leanmind.reactivemvc.application.user_creator.UserCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserCreator userCreator;

    public UserController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto userDto) {
        userCreator.execute(userDto);
        return ResponseEntity.ok().build();
    }
}
