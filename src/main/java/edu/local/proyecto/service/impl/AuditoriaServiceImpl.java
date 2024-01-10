package edu.local.proyecto.service.impl;

import edu.local.proyecto.dao.entity.AuditoriaEntity;
import edu.local.proyecto.dao.repository.AuditoriaRepository;
import edu.local.proyecto.service.AuditoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {
    
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    
    @Override
    public List<AuditoriaEntity> listarTodas(){
        Sort sortByParameter = Sort.by(Sort.Direction.DESC, "tiempoOperacion");
        return auditoriaRepository.findAll(sortByParameter);
    }
    
    @Override
    public void insertar(AuditoriaEntity ae){
        auditoriaRepository.save(ae);
    }
    
}
