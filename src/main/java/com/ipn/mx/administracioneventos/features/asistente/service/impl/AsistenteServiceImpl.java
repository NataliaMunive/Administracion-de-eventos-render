package com.ipn.mx.administracioneventos.features.asistente.service.impl;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipn.mx.administracioneventos.core.domain.Asistente;
import com.ipn.mx.administracioneventos.features.asistente.repository.AsistenteRepository;
import com.ipn.mx.administracioneventos.features.asistente.service.AsistenteService;

@Service
public class AsistenteServiceImpl implements AsistenteService {

    @Autowired
    private AsistenteRepository asistenteRepository;

    @Override
    public List<Asistente> findAll() {
        return asistenteRepository.findAll();
    }

    @Override
    public Asistente findById(Long id) {
        return asistenteRepository.findById(id).orElse(null);
    }

    @Override
    public Asistente save(Asistente asistente) {
        return asistenteRepository.save(asistente);
    }

    @Override
    public void deleteById(Long id) {
        asistenteRepository.deleteById(id);
    }

    @Override
    public ByteArrayInputStream reportePDF(List<Asistente> listaAsistente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
