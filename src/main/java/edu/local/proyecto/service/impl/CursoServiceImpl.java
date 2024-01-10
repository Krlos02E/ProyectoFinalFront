package edu.local.proyecto.service.impl;

import edu.local.proyecto.dao.CursoDAO;
import edu.local.proyecto.dto.CursoDTO;
import edu.local.proyecto.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDAO cursoDAO;

    @Override
    public List<CursoDTO> listarTodos() {
        return cursoDAO.listarCursos();
    }

    @Override
    public CursoDTO obtenerUno(int codigo) {
        return cursoDAO.obtenerUno(codigo);
    }

    @Override
    public void insertar(CursoDTO ce) {
        cursoDAO.insertar(ce);
    }

    @Override
    public void eliminar(int codigo) {
        cursoDAO.eliminar(codigo);
    }
    
    @Override
    public void modificar(CursoDTO ce){
        cursoDAO.modificar(ce);
    }
    
    @Override
    public List<CursoDTO> filtrarPorCiclo(List<CursoDTO> lista, Integer ciclo) {
        
        return cursoDAO.filtrarPorCiclo(lista, ciclo);
    }
    
    @Override
    public List<CursoDTO> filtrarPorProfesor(List<CursoDTO> lista, String profesor) {
        
        return cursoDAO.filtrarPorProfesor(lista, profesor);
    }

    @Override
    public List<CursoDTO> filtrarPorFacultad(List<CursoDTO> lista, String facultad) {
        
        return cursoDAO.filtrarPorFacultad(lista, facultad);
    }

    @Override
    public List<CursoDTO> filtrarPorModalidad(List<CursoDTO> lista, String modalidad) {
        
        return cursoDAO.filtrarPorModalidad(lista, modalidad);
    }

    @Override
    public List<CursoDTO> filtrarPorCreditos(List<CursoDTO> lista, Double creditos) {
        
        return cursoDAO.filtrarPorCreditos(lista, creditos);
    }
    
    
    
}
