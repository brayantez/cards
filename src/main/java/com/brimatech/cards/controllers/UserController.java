package com.brimatech.cards.controllers;

import com.brimatech.cards.dtos.AuthenticateRequest;
import com.brimatech.cards.dtos.CreateUserRequest;
import com.brimatech.cards.services.UserService;
import com.brimatech.cards.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST APIs for User Resource",
        description = "REST APIs - Create User and Authenticate User"
)

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse<?>> createUser(@RequestBody @Valid CreateUserRequest createUserRequest){

        LOGGER.info("New user request with payload {}...", createUserRequest);
        ApiResponse<?> apiResponse = userService.createUser(createUserRequest);

        return new ResponseEntity<>(apiResponse,apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Authenticate User REST API",
            description = "Authenticate User REST API from the database"
    )
    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<?>> authenticate(@RequestBody @Valid AuthenticateRequest authenticateRequest){

        ApiResponse<?> apiResponse = userService.authenticate(authenticateRequest);

        return new ResponseEntity<>(apiResponse, apiResponse.getStatus().equals(ApiResponse.Status.SUCCESS) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }
}
