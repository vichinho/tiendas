package com.tiendas.tiendas.model;

import lombok.Data;

@Data
public class TiendaDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String horarioApertura;
    private String horarioCierre;
}
