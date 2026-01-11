package com.ipn.mx.administracioneventos.util.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ipn.mx.administracioneventos.util.service.EmailService;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String remitente;

    @Override
    public void enviarCorreo(String to, String subject, String body, File file) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(new InternetAddress(remitente, "Administracion de Eventos"));
            messageHelper.addAttachment(file.getName(), file);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(body);
            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo con archivo adjunto", e);
        }
    }
}
