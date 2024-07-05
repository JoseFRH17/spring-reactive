package com.leanmind.reactivemvc.application.user_finder_by_email;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserFinderByEmail {

    private final UserRepository userRepository;

    public UserFinderByEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> execute(String email) {
        return userRepository.findByEmail(email);
    }
}
