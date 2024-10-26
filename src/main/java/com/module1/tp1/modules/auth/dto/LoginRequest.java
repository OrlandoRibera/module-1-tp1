package com.module1.tp1.modules.auth.dto;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull(message = "username is required.") String username,
                           @NotNull(message = "password is required.") String password) {
}
