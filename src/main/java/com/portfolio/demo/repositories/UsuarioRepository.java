package com.portfolio.demo.repositories;

import com.portfolio.demo.Models.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UserServiceModel, Long> {
    
    Optional<UserServiceModel> findByUsername(String username);
    Optional<UserServiceModel> findByPasword(String username);
}
