package com.portfolio.demo.config;

public class RecursoNoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = -3198046624905112775L;

	public RecursoNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
