package com.leanmind.reactivemvc.infrastructure.repository;

import com.leanmind.reactivemvc.infrastructure.entity.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface R2dbCUserRepository extends ReactiveCrudRepository<UserEntity, String> {

    @Query("SELECT * FROM user WHERE email = :email")
    Mono<UserEntity> findByEmail(String email);
}
