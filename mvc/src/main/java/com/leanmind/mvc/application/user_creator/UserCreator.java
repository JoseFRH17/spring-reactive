package com.leanmind.mvc.application.user_creator;

import com.leanmind.mvc.domain.User;
import com.leanmind.mvc.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreator {
  private final UserRepository userRepository;

  public UserCreator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void execute(CreateUserRequestDto userDto) {
    userRepository.save(new User(userDto.name(), userDto.email()));
  }
}
