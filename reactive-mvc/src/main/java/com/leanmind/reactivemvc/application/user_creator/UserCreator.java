package com.leanmind.reactivemvc.application.user_creator;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
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
