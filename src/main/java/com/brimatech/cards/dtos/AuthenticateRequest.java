package com.brimatech.cards.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(
        description = "AuthenticateRequest DTO Model Information"
)
public class AuthenticateRequest {

    @Schema(
            description = "User Email"
    )
    @Email
    @NotEmpty(message = "email is required")
    private String email;

    @Schema(
            description = "User Password"
    )
    @NotEmpty(message = "password is required")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
