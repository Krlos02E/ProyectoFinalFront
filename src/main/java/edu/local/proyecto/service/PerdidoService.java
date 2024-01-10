package edu.local.proyecto.service;

import edu.local.proyecto.dao.entity.PerdidoEntity;
import java.util.List;


public interface PerdidoService {
    
    public List<PerdidoEntity> listarTodos();
    
    public PerdidoEntity obtenerUno(int codigo);

    public void insertar(PerdidoEntity ce);

    public void eliminar(int codigo);
}
