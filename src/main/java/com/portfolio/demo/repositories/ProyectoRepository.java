package com.portfolio.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.demo.Models.ModelProjectModel;

@Repository
public interface ProyectoRepository extends JpaRepository<ModelProjectModel, Long> {
      boolean existsByNombre(String nombre);
}