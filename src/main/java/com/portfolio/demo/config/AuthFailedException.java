package com.portfolio.demo.config;

public class AuthFailedException extends RuntimeException{

	    private static final long serialVersionUID = 1L;

		public AuthFailedException(String mensaje) { super(mensaje); }

}
