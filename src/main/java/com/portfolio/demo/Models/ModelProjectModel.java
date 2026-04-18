package com.portfolio.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "proyectos")
public class ModelProjectModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
	@Size(min = 10, max = 50, message = "El nombre debe tener entre 10 y 50 caracteres")
	private String nombre;
	
	@NotNull(message = "La descripción es obligatoria")
	@Size(min = 10, max = 50, message = "La descripcion debe tener entre 10 y 50 caracteres")
	private String descripcion;
	private String lenguaje;

	public ModelProjectModel() {
	}

	public ModelProjectModel(String nombre, String descripcion, String lenguaje) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lenguaje = lenguaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
}