package com.leanmind.reactivemvc.infrastructure.repository;

import com.leanmind.reactivemvc.infrastructure.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface R2dbCUserRepository extends ReactiveCrudRepository<UserEntity, String> {
}
