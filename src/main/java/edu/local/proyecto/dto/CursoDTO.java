package edu.local.proyecto.dto;

import lombok.Data;

/**
 *
 * @author user
 */
@Data
public class CursoDTO {
    
    private Integer idcurso;
    private Integer ciclo;
    private String nombre;
    private String profesor;
    private String facultad;
    private String modalidad;
    private Double creditos;
    
}
