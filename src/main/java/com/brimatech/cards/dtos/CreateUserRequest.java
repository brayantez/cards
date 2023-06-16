package com.brimatech.cards.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
        description = "CreateUserRequest DTO Model Information"
)
public class CreateUserRequest {

    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "firstname is required")
    private String firstName;

    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "lastname is required")
    private String lastName;

    @Schema(
            description = "User Email"
    )
    @NotEmpty(message = "email is required")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
    @Size(max = 150, message = "email too long")
    private String email;

    @Schema(
            description = "User rOLE"
    )
    @NotEmpty(message = "role is required")
    private String role;

    @Schema(
            description = "User password"
    )
    @NotEmpty(message = "password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,}$", message = "the password has to have at least one uppercase, one lowercase , one number and one special character")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
