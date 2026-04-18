package com.portfolio.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.demo.Models.UserServiceModel;
import com.portfolio.demo.repositories.UsuarioRepository;

@Service
public class UserService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UserServiceModel autenticacion (UserServiceModel usuarioAutenticacion) {
		
		return usuarioAutenticacion;
		
	}
}
