package edu.local.proyecto.dao.repository;

import edu.local.proyecto.dao.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
    
    
}
