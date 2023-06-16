package com.brimatech.cards.services;

import com.brimatech.cards.dtos.AuthenticateRequest;
import com.brimatech.cards.dtos.CreateUserRequest;
import com.brimatech.cards.models.Role;
import com.brimatech.cards.models.User;
import com.brimatech.cards.repositories.RoleRepository;
import com.brimatech.cards.repositories.UserRepository;
import com.brimatech.cards.security.JwtTokenProviderService;
import com.brimatech.cards.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProviderService jwtTokenProviderService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProviderService jwtTokenProviderService, AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProviderService = jwtTokenProviderService;
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
    }

    public ApiResponse<?> createUser(CreateUserRequest userRequest){
        Role role = roleRepository.findByName(userRequest.getRole());
        ApiResponse<?> apiResponse = new ApiResponse<>();
        User user = new User();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRoles(List.of(role));
        User response = userRepository.save(user);

        String jwtToken = jwtTokenProviderService.generateToken(response);
        apiResponse.setToken(jwtToken);
        apiResponse.setStatus(ApiResponse.Status.SUCCESS);
        apiResponse.setMessage("User created successfully");
        LOGGER.info("Initiating create new user request - {}", userRequest);
        return apiResponse;
    }

    public ApiResponse<?> authenticate(AuthenticateRequest authenticateRequest){

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(),
                authenticateRequest.getPassword()));

        final UserDetails user = customUserDetailsService.loadUserByUsername(authenticateRequest.getEmail());

        ApiResponse<?> apiResponse = new ApiResponse<>();

        final String jwtToken = jwtTokenProviderService.generateToken(user);
        apiResponse.setToken(jwtToken);
        apiResponse.setStatus(ApiResponse.Status.SUCCESS);
        apiResponse.setMessage("Authenticated successfully");

        return apiResponse;
    }
}
