package com.leanmind.reactivemvc.infrastructure.entity;

import com.leanmind.reactivemvc.domain.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_account")
public record UserEntity(
    @Id
    String email,
    String name
) implements Persistable<String>  {
    public static UserEntity from(User user){
        return new UserEntity(user.email(), user.name());
    }

    @Override
    public String getId() {
        return email;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
