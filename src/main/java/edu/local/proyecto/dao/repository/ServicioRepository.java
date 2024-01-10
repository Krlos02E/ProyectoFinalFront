package edu.local.proyecto.dao.repository;

import edu.local.proyecto.dao.entity.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface ServicioRepository extends JpaRepository<ServicioEntity, Integer> {
    
}
