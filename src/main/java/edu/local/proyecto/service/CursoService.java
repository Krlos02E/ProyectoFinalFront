package edu.local.proyecto.service;

import edu.local.proyecto.dto.CursoDTO;
import java.util.List;

public interface CursoService {
    
    public List<CursoDTO> listarTodos();

    public CursoDTO obtenerUno(int codigo);

    public void insertar(CursoDTO ce);

    public void eliminar(int codigo);
    
    public void modificar(CursoDTO ce);
    
    public List<CursoDTO> filtrarPorCiclo(List<CursoDTO> lista, Integer ciclo);
    
    public List<CursoDTO> filtrarPorProfesor(List<CursoDTO> lista, String profesor);
    
    public List<CursoDTO> filtrarPorFacultad(List<CursoDTO> lista, String facultad);
    
    public List<CursoDTO> filtrarPorModalidad(List<CursoDTO> lista, String modalidad);

    public List<CursoDTO> filtrarPorCreditos(List<CursoDTO> lista, Double creditos);
    
}
