package com.tiendas.tiendas.controller;

import com.tiendas.tiendas.model.TiendaDTO;
import com.tiendas.tiendas.model.TiendaHorarioDTO;
import com.tiendas.tiendas.service.TiendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiendas")
@RequiredArgsConstructor
public class TiendaController {
    private final TiendaService tiendaService;

    @PostMapping
    public ResponseEntity<TiendaDTO> crearTienda(@RequestBody TiendaDTO tiendaDTO) {
        return ResponseEntity.ok(tiendaService.crearTienda(tiendaDTO));
    }

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> listarTiendas() {
        return ResponseEntity.ok(tiendaService.listarTiendas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> obtenerTiendaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tiendaService.obtenerTiendaPorId(id));
    }

    @PatchMapping("/{id}/horario")  // <- Usa PATCH, no GET
public ResponseEntity<TiendaDTO> actualizarHorario(
        @PathVariable Long id,
        @RequestBody TiendaHorarioDTO horarioDTO) {
    return ResponseEntity.ok(tiendaService.actualizarHorario(id, horarioDTO));
}
}
