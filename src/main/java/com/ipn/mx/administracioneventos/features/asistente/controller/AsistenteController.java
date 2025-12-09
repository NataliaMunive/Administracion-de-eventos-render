package com.ipn.mx.administracioneventos.features.asistente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipn.mx.administracioneventos.core.domain.Asistente;
import com.ipn.mx.administracioneventos.features.asistente.service.AsistenteService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1/asistentes")
public class AsistenteController {

    @Autowired
    private AsistenteService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Asistente> readAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> readById(@PathVariable Long id) {
        Asistente asistente = null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            asistente = service.findById(id);

        } catch (DataAccessException e) {
            respuesta.put("mensaje", "Error al realizar la consulta en la base de datos");
            respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (asistente == null) {
            respuesta.put("mensaje",
                    "El asistente con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Asistente>(asistente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Asistente asistente) {
        Asistente a = null;
        Map<String, Object> respuesta = new HashMap<>();
        try {
            a = service.save(asistente);
        } catch (DataAccessException ex) {
            respuesta.put("mensaje", "Error al insertar el asistente en la base de datos");
            respuesta.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El asistente se ha creado con éxito");
        respuesta.put("asistente", a);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Asistente asistente, @PathVariable Long id) {
        Asistente a = service.findById(id);
        Asistente asistenteActualizado = null;
        Map<String, Object> respuesta = new HashMap<>();
        if (a == null) {
            respuesta.put("mensaje", "Error: no se pudo editar el asistente con ID: "
                    .concat(id.toString().concat("no existe en la bd")));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
        try {
            a.setNombre(asistente.getNombre());
            a.setPaterno(asistente.getPaterno());
            a.setMaterno(asistente.getMaterno());
            a.setEmail(asistente.getEmail());
            a.setFechaRegistro(asistente.getFechaRegistro());
            a.setEvento(asistente.getEvento());

            asistenteActualizado = service.save(a);

        } catch (DataAccessException ex) {
            respuesta.put("mensaje", "Error al actualizar el asistente en la base de datos");
            respuesta.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El asistente se ha actualizado con éxito");
        respuesta.put("asistente", asistenteActualizado);
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Asistente a = service.findById(id);
        Map<String, Object> respuesta = new HashMap<>();
        if (a == null) {
            respuesta.put("mensaje", "Error: no se pudo eliminar el asistente con ID: "
                    .concat(id.toString().concat("no existe en la bd")));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
        }
        try {
            service.deleteById(id);

        } catch (DataAccessException ex) {
            respuesta.put("mensaje", "Error al eliminar el registro en la base de datos");
            respuesta.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        respuesta.put("mensaje", "El asistente se ha eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
    }
}
