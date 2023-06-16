package com.brimatech.cards.repositories;

import com.brimatech.cards.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional <User> findByEmail(String email);
}
