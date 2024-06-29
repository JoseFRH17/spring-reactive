package com.leanmind.mvc.application;

public record CreateUserRequestDto(
    String name,
    String email
) {}
