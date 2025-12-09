package com.ipn.mx.administracioneventos.features.asistente.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.ipn.mx.administracioneventos.core.domain.Asistente;

public interface AsistenteService {

    public List<Asistente> findAll();

    public Asistente findById(Long id);

    public Asistente save(Asistente asistente);

    public void deleteById(Long id);

    public ByteArrayInputStream reportePDF(List<Asistente> listaAsistente);
}
