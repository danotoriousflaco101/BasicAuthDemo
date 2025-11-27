package com.flaco.basicauthdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.flaco.basicauthdemo.model.AppUser;
import com.flaco.basicauthdemo.repository.AppUserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final AppUserRepository repository;
    private final PasswordEncoder encoder;

    // Dependencies Injection (Repository e BCrypt Encoder)
    public DataLoader(AppUserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // DEBUG Messaggio per confermare che il loader è partito
        System.out.println("--- DATA LOADER RUNNING: CHECK DB... ---");

        // Controlliamo se il DB è vuoto prima di inserire (buona norma!!)
        if (repository.count() == 0) {
            
            // USER
            // encoder.encode() perché nel DB le password DEVONO essere hashate!
            repository.save(new AppUser("user", encoder.encode("password"), "USER"));
            
            // ADMIN
            repository.save(new AppUser("admin", encoder.encode("admin123"), "ADMIN"));

            System.out.println("--- CREATED USERS AND SAVED ON DB H2 ---");
        } else {
            System.out.println("--- DB FULL (USERS FOUND: " + repository.count() + ") ---"); 
        }
    }
}