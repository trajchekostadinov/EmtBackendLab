package com.example.emtbackendlab.config;
import com.example.emtbackendlab.model.domain.User;
import com.example.emtbackendlab.model.enumeration.Role;
import com.example.emtbackendlab.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User("Admin", "Admin", "admin@admin.com", "admin", passwordEncoder.encode("admin"));
            admin.setRole(Role.ROLE_ADMINISTRATOR);
            userRepository.save(admin);
            System.out.println("Admin user created: admin/admin");
        }
    }
}
