package edu.local.proyecto.service;


import edu.local.proyecto.dao.entity.ServicioEntity;
import java.util.List;

/**
 *
 * @author user
 */
public interface ServicioService {
    
    public List<ServicioEntity> listarTodos();

    public void insertar(ServicioEntity se);

    public void eliminar(int codigo);
    
}
