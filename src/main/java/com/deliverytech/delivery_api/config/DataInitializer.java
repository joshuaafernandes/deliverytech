package com.deliverytech.delivery_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.deliverytech.delivery_api.enums.Role;
import com.deliverytech.delivery_api.model.User;
import com.deliverytech.delivery_api.repository.UserRepository;

@Configuration
@Profile("!test")
public class DataInitializer implements CommandLineRunner{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... dados){
        if(!userRepository.existsByEmail("cliente@gmail.com")){
            User cliente = new User();
            cliente.setNome("Cliente Nome");
            cliente.setEmail("cliente@gmail.com");
            cliente.setSenha(passwordEncoder.encode("12345"));
            cliente.setRole(Role.CLIENTE);
            cliente.setAtivo(true);
            userRepository.save(cliente);
        }   

        if(!userRepository.existsByEmail("restaurante@gmail.com")){
            User restaurante = new User();
                restaurante.setNome("Restaurante Nome");
                restaurante.setEmail("restaurante@gmail.com");
                restaurante.setSenha(passwordEncoder.encode("12345"));
                restaurante.setRole(Role.RESTAURANTE);
                restaurante.setAtivo(true);
                userRepository.save(restaurante);
        }

        if(!userRepository.existsByEmail("admin@gmail.com")){
            User admin = new User();
                admin.setNome("Admin Nome");
                admin.setEmail("admin@gmail.com");
                admin.setSenha(passwordEncoder.encode("testando"));
                admin.setRole(Role.ADMIN);
                admin.setAtivo(true);
                userRepository.save(admin);
        }
        System.out.println("Usuários inicias criados com sucesso!");
    }

}