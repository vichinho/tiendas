package com.tiendas.tiendas.model;

import lombok.Data;

@Data  // Lombok generará automáticamente getters/setters
public class TiendaHorarioDTO {
    private String horarioApertura;
    private String horarioCierre;
}