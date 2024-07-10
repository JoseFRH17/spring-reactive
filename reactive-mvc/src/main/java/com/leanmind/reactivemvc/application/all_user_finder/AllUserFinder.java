package com.leanmind.reactivemvc.application.all_user_finder;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AllUserFinder {
    private final UserRepository userRepository;

    public AllUserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> execute() {
        return userRepository.findAll();
    }
}
