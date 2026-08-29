package com.avijitdey255.loging_spring_secqurity.repository;

import com.avijitdey255.loging_spring_secqurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
