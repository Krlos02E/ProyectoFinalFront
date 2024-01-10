package edu.local.proyecto.service;

import edu.local.proyecto.dao.entity.AuditoriaEntity;
import java.util.List;


public interface AuditoriaService {
    
    public List<AuditoriaEntity> listarTodas();
    
    public void insertar(AuditoriaEntity ae);
    
}
