package com.portfolio.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.DTO.ProjectDTO.ProyectoDTO;
import com.portfolio.demo.Models.ModelProjectModel;
import com.portfolio.demo.repositories.ProyectoRepository;

@Service
public class ProjectService {

	@Autowired
	private ProyectoRepository proyectoRepository;

	public ModelProjectModel guardarProyecto(ModelProjectModel proyecto) {
		if (proyectoRepository.existsByNombre(proyecto.getNombre())) {
			throw new RuntimeException("Ya existe un proyecto con ese nombre");
		}
		return proyectoRepository.save(proyecto);
	};

	public ModelProjectModel actualizarProyecto(Long id, ModelProjectModel datosActualizados) {
		if (id == null || id <= 0) {
			throw new RuntimeException("El Id no puede estar vacio y debe ser mayor a 0");
		}
		return proyectoRepository.findById(id).map(proyecto -> {
			proyecto.setNombre(datosActualizados.getNombre());
			proyecto.setDescripcion(datosActualizados.getDescripcion());
			proyecto.setLenguaje(datosActualizados.getLenguaje());
			return proyectoRepository.save(proyecto);
		}).orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id " + id));
	}
	
	public ModelProjectModel buscarPorId(Long id) {
	    return proyectoRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id " + id));
	}
	
	public ProyectoDTO obtenerProyecto(Long id) {
	    ModelProjectModel p = proyectoRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("No encontrado"));
	    
	    return new ProyectoDTO(p.getId(), p.getNombre(), p.getDescripcion(), p.getLenguaje());
	}
}
