package com.leanmind.reactivemvc.infrastructure.entity;

import com.leanmind.reactivemvc.domain.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("User")
public record UserEntity (
    @Id
    String email,
    String name
){
    public static UserEntity from(User user){
        return new UserEntity(user.email(), user.name());
    }
}
