package com.leanmind.reactivemvc.application.user_creator;

public record CreateUserRequestDto(
    String name,
    String email
) {}
