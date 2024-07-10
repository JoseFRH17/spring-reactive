package com.leanmind.reactivemvc.application.user_creator;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserCreator {
  private final UserRepository userRepository;

  public UserCreator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Mono<User> execute(CreateUserRequestDto userDto) {
    return userRepository.save(new User(userDto.name(), userDto.email()));
  }
}
