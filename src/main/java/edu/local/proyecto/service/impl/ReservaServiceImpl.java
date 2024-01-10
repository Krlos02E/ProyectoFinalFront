/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.local.proyecto.service.impl;

import edu.local.proyecto.dao.entity.ReservaEntity;
import edu.local.proyecto.dao.repository.ReservaRepository;
import edu.local.proyecto.dao.repository.ServicioRepository;
import edu.local.proyecto.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<ReservaEntity> listarTodos() {
        Sort sortByParameter = Sort.by(Sort.Direction.DESC, "fechaServicio");
        return reservaRepository.findAll(sortByParameter);
    }
    
    @Override
    public ReservaEntity obtenerUno(int codigo){
        return reservaRepository.findById(codigo).get();
    }

    @Override
    public void insertar(ReservaEntity ce) {
        reservaRepository.save(ce);
    }


    @Override
    public void eliminar(int codigo) {
        reservaRepository.deleteById(codigo);
    }
}
