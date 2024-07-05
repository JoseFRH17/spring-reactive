package com.leanmind.mvc.application.user_creator;

public record CreateUserRequestDto(
    String name,
    String email
) {}
