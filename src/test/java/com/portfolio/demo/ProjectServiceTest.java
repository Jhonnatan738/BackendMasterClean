package com.portfolio.demo;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.portfolio.demo.DTO.ProjectDTO.ProyectoDTO;
import com.portfolio.demo.Models.ModelProjectModel;
import com.portfolio.demo.repositories.ProyectoRepository;
import com.portfolio.demo.services.ProjectService;

@ExtendWith(MockitoExtension.class) 
class ProyectoServiceTest {

    @Mock
    private ProyectoRepository proyectoRepository; 

    @InjectMocks
    private ProjectService proyectoService; 

    @Test
    void cuandoBuscarPorId_entoncesRetornaDTO() {
        ModelProjectModel proyectoFake = new ModelProjectModel("Mi Proyecto", "Descripción", "imagen.png");
        

        when(proyectoRepository.findById(1L)).thenReturn(Optional.of(proyectoFake));


        ProyectoDTO resultado = proyectoService.obtenerProyecto(1L);


        assertNotNull(resultado);
        assertEquals("Mi Proyecto", resultado.nombre());
        verify(proyectoRepository, times(1)).findById(1L);
    }
}