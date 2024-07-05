package com.leanmind.mvc.application.all_users_finder;

import com.leanmind.mvc.domain.User;
import com.leanmind.mvc.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllUsersFinder {

    private final UserRepository userRepository;

    public AllUsersFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute(){
        return userRepository.findAll();
    }
}
