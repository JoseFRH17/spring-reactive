package com.leanmind.mvc.infrastructure.controller;

import com.leanmind.mvc.application.CreateUserRequestDto;
import com.leanmind.mvc.application.UserCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  private UserCreator userCreator;

  public UserController(UserCreator userCreator) {
    this.userCreator = userCreator;
  }

  @GetMapping
  public String hello() {
    return "<h1>Hello, user!</h1>";
  }

  @PostMapping
  public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDto userDto) {
    userCreator.execute(userDto);
    return ResponseEntity.ok().build();
  }
}
