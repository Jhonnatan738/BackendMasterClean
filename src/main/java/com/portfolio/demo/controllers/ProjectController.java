package com.portfolio.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.demo.Models.ModelProjectModel;
import com.portfolio.demo.repositories.ProyectoRepository;
import com.portfolio.demo.services.ProjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
public class ProjectController {

	@Autowired 
    private ProyectoRepository proyectoRepository;
	@Autowired
	private ProjectService projectService;

	@Operation(summary = "Obtener todos los proyectos", description = "Retorna una lista de todos los proyectos guardados en la base de datos de PostgreSQL")
    @GetMapping("/proyectos")
    public List<ModelProjectModel> obtenerProyectos() {
        return proyectoRepository.findAll();
    }
	
	@Operation(summary = "Obtener un proyecto especifico, guardado por ID", description = "Retorna un proyecto guardado en la base de datos de PostgreSQL")
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Registro Encontrado con éxito"),
		    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
		})
    @GetMapping("/proyectos/{id}")
    public ModelProjectModel obtenerProyectosPorId(@PathVariable Long id) {
        return projectService.buscarPorId(id);
    }
	
	@Operation(summary = "Crear un nuevo proyecto", description = "Guarda un proyecto en la base de datos. Requiere nombre, descripción y lenguaje.")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Proyecto creado con éxito"),
	    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
	})
    @PostMapping("/proyectos")
    public ModelProjectModel crearProyecto(@Valid @RequestBody ModelProjectModel nuevoProyecto) {
        return projectService.guardarProyecto(nuevoProyecto);
    }
    
	@Operation(summary = "modificar un proyecto existente", description = "Modifica el registro de un proyecto existente.")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Proyecto modificado con éxito"),
	    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
	})
    @PutMapping("/proyectos/{id}")
    public ModelProjectModel actualizarProyecto(@PathVariable Long id, @Valid @RequestBody ModelProjectModel datosActualizados) {
        return projectService.actualizarProyecto(id, datosActualizados);

    }
	
	@Operation(summary = "eliminar un proyecto existente", description = "Elimina el registro de un proyecto existente.")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Proyecto eliminado con éxito"),
	    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
	})
    @DeleteMapping("/proyectos/{id}")
    public String borrarProyecto(@PathVariable Long id) {
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return "Proyecto con ID " + id + " eliminado correctamente.";
        } else {
            return "No se pudo eliminar: El proyecto con ID " + id + " no existe.";
        }
    }
}