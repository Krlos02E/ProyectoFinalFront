package edu.local.proyecto.service.impl;

import edu.local.proyecto.dao.entity.PerdidoEntity;
import edu.local.proyecto.dao.repository.PerdidoRepository;
import edu.local.proyecto.service.PerdidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PerdidoServiceImpl implements PerdidoService {
    
    @Autowired
    private PerdidoRepository perdidoRepository;
    
    @Override
    public List<PerdidoEntity> listarTodos(){
        Sort sortByParameter = Sort.by(Sort.Direction.DESC, "fechaPerdida");
        return perdidoRepository.findAll(sortByParameter);
    }

    @Override
    public PerdidoEntity obtenerUno(int codigo) {
        return perdidoRepository.findById(codigo).get();
    }

    @Override
    public void insertar(PerdidoEntity ce) {
        perdidoRepository.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        perdidoRepository.deleteById(codigo);
    }
    
    
    
}
