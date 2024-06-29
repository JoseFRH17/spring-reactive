package com.leanmind.mvc.infrastructure.repository;

import com.leanmind.mvc.domain.User;
import com.leanmind.mvc.domain.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostgresUserRepository implements UserRepository {
  private final JdbcTemplate jdbcTemplate;

  public PostgresUserRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void save(User user) {
    jdbcTemplate.update(
        "INSERT INTO \"User\" (name, email) VALUES (?, ?)",
        user.name(),
        user.email()
    );
  }

}
