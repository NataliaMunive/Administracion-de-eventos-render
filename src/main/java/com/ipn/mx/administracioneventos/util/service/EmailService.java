package com.ipn.mx.administracioneventos.util.service;

public interface EmailService {

    void enviarCorreo(String to, String subject, String text);
}
