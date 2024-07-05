package com.leanmind.mvc.infrastructure.repository;

import com.leanmind.mvc.domain.User;
import com.leanmind.mvc.domain.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostgresUserRepository implements UserRepository {
  private final NamedParameterJdbcTemplate jdbcTemplate;

  public PostgresUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void save(User user) {
    jdbcTemplate.update(
        "INSERT INTO \"User\" (name, email) VALUES (:name, :value)",
        Map.of("name", user.name(), "value", user.email())
    );
  }

  @Override
  public Optional<User> findByEmail(String email) {
    var result = jdbcTemplate.query(
      "SELECT * FROM \"User\" WHERE email = :email",
      Map.of("email", email),
      (rs, rowNum) -> new User(rs.getString("name"), rs.getString("email"))
    );

    return result.isEmpty() ? Optional.empty() : Optional.of(result.getFirst());
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(
      "SELECT * FROM \"User\"",
      (rs, rowNum) -> new User(rs.getString("name"), rs.getString("email"))
    );
  }

}
