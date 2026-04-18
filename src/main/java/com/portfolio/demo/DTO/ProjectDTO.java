package com.portfolio.demo.DTO;

public class ProjectDTO {

	public record ProyectoDTO(
		    Long id,
		    String nombre,
		    String descripcion,
		    String urlImagen
		) {}

}
