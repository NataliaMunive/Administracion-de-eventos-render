package com.ipn.mx.administracioneventos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministracioneventosApplication implements CommandLineRunner {

    /* @Autowired
    private EmailService emailService; */
    public static void main(String[] args) {
        SpringApplication.run(AdministracioneventosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicación iniciada correctamente.");
        /* String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        String to = "gorreo";
        String subject = "Correo de prueba desde Spring Boot";
        emailService.enviarCorreo(to, subject, texto); */
    }

}
