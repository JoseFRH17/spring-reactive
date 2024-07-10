package com.leanmind.reactivemvc.infrastructure.adapter;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
import com.leanmind.reactivemvc.infrastructure.entity.UserEntity;
import com.leanmind.reactivemvc.infrastructure.repository.R2dbCUserRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PostgresUserRepository implements UserRepository {

    private final R2dbCUserRepository r2dbCUserRepository;

    public PostgresUserRepository(R2dbCUserRepository r2dbCUserRepository) {
        this.r2dbCUserRepository = r2dbCUserRepository;
    }

    @Override
    public Mono<User> save(User user) {
        return r2dbCUserRepository.save(UserEntity.from(user))
            .map(userEntity -> new User(userEntity.name(), userEntity.email()));
    }

    @Override
    public Mono<User> findByEmail(String email) {
        return r2dbCUserRepository.findById(email)
                .map(userEntity -> new User(userEntity.name(), userEntity.email()));
    }

    @Override
    public Flux<User> findAll() {
        return r2dbCUserRepository.findAll()
                .map(userEntity -> new User(userEntity.name(), userEntity.email()));
    }
}
