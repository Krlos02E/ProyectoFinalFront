package edu.local.proyecto.dao.repository;

import edu.local.proyecto.dao.entity.PerdidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PerdidoRepository  extends JpaRepository<PerdidoEntity, Integer>{
    
}
