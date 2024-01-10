package edu.local.proyecto.service;

import edu.local.proyecto.dao.entity.ReservaEntity;
import java.util.List;


public interface ReservaService {
    
    public List<ReservaEntity> listarTodos();
    
    public ReservaEntity obtenerUno(int codigo);

    public void insertar(ReservaEntity re);

    public void eliminar(int codigo);
}
