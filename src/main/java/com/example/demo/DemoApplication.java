package com.example.demo;

import com.example.demo.entities.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(Patient.builder()
                            .nom("jalal")
                            .prenom("Hassan")
                            .dateNaissance(new Date())
                            .score(5)
                            .malade(true)
                    .build());
            patientRepository.save(Patient.builder()
                    .nom("fath")
                    .prenom("ali")
                    .dateNaissance(new Date())
                    .score(0)
                    .malade(false)
                    .build());
            patientRepository.save(Patient.builder()
                    .nom("nasr")
                    .prenom("imane")
                    .dateNaissance(new Date())
                    .score(10)
                    .malade(true)
                    .build());
        };
        }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}