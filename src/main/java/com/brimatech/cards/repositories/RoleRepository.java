package com.brimatech.cards.repositories;

import com.brimatech.cards.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String role);
}
