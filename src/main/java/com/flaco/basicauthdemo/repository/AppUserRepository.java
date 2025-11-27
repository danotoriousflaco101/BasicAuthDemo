package com.flaco.basicauthdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.flaco.basicauthdemo.model.AppUser;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    // Spring genera la query SQL per cercare per username
    Optional<AppUser> findByUsername(String username);
}