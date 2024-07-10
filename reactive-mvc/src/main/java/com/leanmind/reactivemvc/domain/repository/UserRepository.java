package com.leanmind.reactivemvc.domain.repository;

import com.leanmind.reactivemvc.domain.models.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<User> save(User user);

    Mono<User> findByEmail(String email);

    Flux<User> findAll();
}
