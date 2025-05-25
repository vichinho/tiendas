package com.tiendas.tiendas.service;


import com.tiendas.tiendas.model.Tienda;
import com.tiendas.tiendas.model.TiendaDTO;
import com.tiendas.tiendas.model.TiendaHorarioDTO;
import com.tiendas.tiendas.repository.TiendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TiendaService {
    private final TiendaRepository tiendaRepository;

    public TiendaDTO crearTienda(TiendaDTO tiendaDTO) {
        Tienda tienda = mapToEntity(tiendaDTO);
        Tienda nuevaTienda = tiendaRepository.save(tienda);
        return mapToDTO(nuevaTienda);
    }

    public List<TiendaDTO> listarTiendas() {
        return tiendaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TiendaDTO obtenerTiendaPorId(Long id) {
        Tienda tienda = tiendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));
        return mapToDTO(tienda);
    }

    // Mappers
    private Tienda mapToEntity(TiendaDTO dto) {
        Tienda tienda = new Tienda();
        tienda.setNombre(dto.getNombre());
        tienda.setDireccion(dto.getDireccion());
        tienda.setCiudad(dto.getCiudad());
        tienda.setHorarioApertura(dto.getHorarioApertura());
        tienda.setHorarioCierre(dto.getHorarioCierre());
        return tienda;
    }

    private TiendaDTO mapToDTO(Tienda tienda) {
        TiendaDTO dto = new TiendaDTO();
        dto.setId(tienda.getId());
        dto.setNombre(tienda.getNombre());
        dto.setDireccion(tienda.getDireccion());
        dto.setCiudad(tienda.getCiudad());
        dto.setHorarioApertura(tienda.getHorarioApertura());
        dto.setHorarioCierre(tienda.getHorarioCierre());
        return dto;
    }
    public TiendaDTO actualizarHorario(Long id, TiendaHorarioDTO horarioDTO) {
    Tienda tienda = tiendaRepository.findById(id)
            .orElseThrow();
    
    tienda.actualizarHorario(horarioDTO.getHorarioApertura(), horarioDTO.getHorarioCierre());
    Tienda tiendaActualizada = tiendaRepository.save(tienda);
    
    return mapToDTO(tiendaActualizada);
}
}

