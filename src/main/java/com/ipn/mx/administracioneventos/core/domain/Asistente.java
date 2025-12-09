package com.ipn.mx.administracioneventos.core.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Asistente", schema = "public")
public class Asistente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAsistente;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 2, max = 50, message = "El valor debe estar entre 2 y 50 caracteres")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Size(min = 2, max = 50, message = "El valor debe estar entre 2 y 50 caracteres")
    @Column(name = "paterno", length = 50, nullable = false)
    private String paterno;

    @Size(min = 2, max = 50, message = "El valor debe estar entre 2 y 50 caracteres")
    @Column(name = "materno", length = 50, nullable = false)
    private String materno;

    @Email(message = "Escribe un correo electronico valido")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaRegistro", nullable = false)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idEvento", nullable = false)
    @JsonBackReference
    private Evento evento;

}
