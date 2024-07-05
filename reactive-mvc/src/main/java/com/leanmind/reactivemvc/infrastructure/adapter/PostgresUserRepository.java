package com.leanmind.reactivemvc.infrastructure.adapter;

import com.leanmind.reactivemvc.domain.models.User;
import com.leanmind.reactivemvc.domain.repository.UserRepository;
import com.leanmind.reactivemvc.infrastructure.entity.UserEntity;
import com.leanmind.reactivemvc.infrastructure.repository.R2dbCUserRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresUserRepository implements UserRepository {

    private final R2dbCUserRepository r2dbCUserRepository;

    public PostgresUserRepository(R2dbCUserRepository r2dbCUserRepository) {
        this.r2dbCUserRepository = r2dbCUserRepository;
    }

    @Override
    public void save(User user) {
        r2dbCUserRepository.save(UserEntity.from(user));
    }
}
