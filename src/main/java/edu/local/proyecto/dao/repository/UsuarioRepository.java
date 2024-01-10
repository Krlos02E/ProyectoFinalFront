package edu.local.proyecto.dao.repository;

import edu.local.proyecto.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {
    
    
}