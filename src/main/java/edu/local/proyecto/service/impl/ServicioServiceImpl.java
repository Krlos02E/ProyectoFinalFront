package edu.local.proyecto.service.impl;

import edu.local.proyecto.dao.entity.ServicioEntity;
import edu.local.proyecto.dao.repository.ServicioRepository;
import edu.local.proyecto.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicioServiceImpl implements ServicioService {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<ServicioEntity> listarTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public void insertar(ServicioEntity ce) {
        servicioRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        servicioRepository.deleteById(codigo);
    }
    
}
