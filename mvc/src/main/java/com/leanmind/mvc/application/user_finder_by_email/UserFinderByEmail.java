package com.leanmind.mvc.application.user_finder_by_email;

import com.leanmind.mvc.domain.User;
import com.leanmind.mvc.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFinderByEmail {

    private final UserRepository userRepository;

    public UserFinderByEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> execute(String email){
        return userRepository.findByEmail(email);
    }
}
