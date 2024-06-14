package com.Launyx.Project.config;

import com.Launyx.Project.entities.User;
import com.Launyx.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// especificando esta classe como de configuração e específica para o perfil de test
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    // Annotation para Associar instância e dependencia de outro objeto
    @Autowired
    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
