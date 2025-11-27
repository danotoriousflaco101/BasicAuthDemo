package com.flaco.basicauthdemo.service;

import com.flaco.basicauthdemo.model.AppUser;
import com.flaco.basicauthdemo.repository.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private final AppUserRepository repository;

    public CustomerUserDetailsService(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // cerca l'utente nel DB H2
        AppUser appUser = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));

        // converto "AppUser" (Entità DB) in "UserDetails" (Oggetto Security)
        // Spring Security si aspetta i ruoli, non serve il prefisso "ROLE_" qui perché
        // lo aggiunge automaticamente internamente con .roles() ;) 
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword()) // È già hashata nel DB!
                .roles(appUser.getRole()) // "ADMIN" -> diventa "ROLE_ADMIN" internamente
                .build();
    }
}