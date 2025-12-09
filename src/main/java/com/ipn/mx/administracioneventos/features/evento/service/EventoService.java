package com.ipn.mx.administracioneventos.features.evento.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ipn.mx.administracioneventos.core.domain.Evento;

public interface EventoService {

    public List<Evento> findAll();

    public Evento findById(Long id);

    public Evento save(Evento evento);

    public void deleteById(Long id);

    public ByteArrayInputStream reportePDF(List<Evento> listaEventos);
}
