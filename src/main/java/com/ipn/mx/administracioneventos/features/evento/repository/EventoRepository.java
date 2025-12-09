package com.ipn.mx.administracioneventos.features.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.mx.administracioneventos.core.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    //Crear consulta en JPQL que me devuelva un evento por nombre
}
