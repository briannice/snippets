package com.briannice.snippets.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "User must have a username")
    private String username;

    @NotBlank(message = "User must have a password")
    private String password;

    @NotBlank(message = "User must have a firstname")
    private String firstname;

    @NotBlank(message = "User must have a lastname")
    private String lastname;
}
