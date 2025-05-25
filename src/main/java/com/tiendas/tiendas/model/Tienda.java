package com.tiendas.tiendas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tiendas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String ciudad;

    @Column(name = "horario_apertura")
    private String horarioApertura;

    @Column(name = "horario_cierre")
    private String horarioCierre;

    public void actualizarHorario(String nuevoHorarioApertura, String nuevoHorarioCierre) {
    this.horarioApertura = nuevoHorarioApertura;
    this.horarioCierre = nuevoHorarioCierre;
}
}

