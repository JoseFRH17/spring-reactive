package com.leanmind.reactivemvc.domain.repository;

import com.leanmind.reactivemvc.domain.models.User;

public interface UserRepository {

    void save(User user);
}
