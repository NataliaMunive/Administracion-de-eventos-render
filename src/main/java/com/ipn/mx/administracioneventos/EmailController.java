package com.ipn.mx.administracioneventos;

import com.ipn.mx.administracioneventos.util.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String enviarCorreoDesdePostman(@RequestParam String to) {

        String subject = "Prueba desde Postman";
        String body = "Hola, este correo fue enviado desde Postman.";

        File file = new File("src/main/java/com/ipn/mx/administracioneventos/util/service/impl/cinnamoroll.png");

        emailService.enviarCorreo(to, subject, body, file);

        return "¡Éxito! Correo enviado a: " + to;
    }
}
