package com.ipn.mx.administracioneventos.util.service;

public interface EmailService {
    void enviarCorreo(String to, String subject, String body, java.io.File file);
}
