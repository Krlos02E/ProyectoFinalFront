package edu.local.proyecto.dao.impl;

import edu.local.proyecto.dao.CursoDAO;
import edu.local.proyecto.dto.CursoDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CursoDAOImpl implements CursoDAO {

    private RestTemplate restTemplate;
    @Value("${uri.rest.cursos}")
    private String urlServidor;

    public CursoDAOImpl() {
        restTemplate = new RestTemplate();
    }

    @Override
    public List<CursoDTO> listarCursos() {
        List<CursoDTO> rpta = null;
        CursoDTO[] lista = restTemplate.getForObject(urlServidor, CursoDTO[].class);
        rpta = Arrays.asList(lista);
        return rpta;
    }

    @Override
    public CursoDTO obtenerUno(int codigo) {
        CursoDTO rpta = null;
        rpta = restTemplate.getForObject(urlServidor + "/" + codigo, CursoDTO.class);
        return rpta;
    }

    @Override
    public void insertar(CursoDTO ce) {
        restTemplate.postForEntity(urlServidor, ce, CursoDTO.class);
    }

    @Override
    public void modificar(CursoDTO ce) {
        restTemplate.put(urlServidor + "/" + ce.getIdcurso(), ce);
    }

    @Override
    public void eliminar(int codigo) {
        restTemplate.delete(urlServidor + "/" + codigo);
    }

    @Override
    public List<CursoDTO> filtrarPorCiclo(List<CursoDTO> lista, Integer ciclo) {

        List<CursoDTO> listaFiltrada = new ArrayList<>();
        for (CursoDTO actual : lista) {
            if (!actual.getCiclo().equals(ciclo)) continue;
            listaFiltrada.add(actual);
        }

        return listaFiltrada;
    }

    @Override
    public List<CursoDTO> filtrarPorProfesor(List<CursoDTO> lista, String profesor) {

        List<CursoDTO> listaFiltrada = new ArrayList<>();
        for (CursoDTO actual : lista) {
            if (!actual.getProfesor().equalsIgnoreCase(profesor)) continue;
            listaFiltrada.add(actual);
        }

        return listaFiltrada;
    }

    @Override
    public List<CursoDTO> filtrarPorFacultad(List<CursoDTO> lista, String facultad) {

        List<CursoDTO> listaFiltrada = new ArrayList<>();
        for (CursoDTO actual : lista) {
            if (!actual.getFacultad().equalsIgnoreCase(facultad)) continue;
            listaFiltrada.add(actual);
        }

        return listaFiltrada;
    }

    @Override
    public List<CursoDTO> filtrarPorModalidad(List<CursoDTO> lista, String modalidad) {

        List<CursoDTO> listaFiltrada = new ArrayList<>();
        for (CursoDTO actual : lista) {
            if (!actual.getModalidad().equalsIgnoreCase(modalidad)) continue;
            listaFiltrada.add(actual);
        }

        return listaFiltrada;
    }

    @Override
    public List<CursoDTO> filtrarPorCreditos(List<CursoDTO> lista, Double creditos) {

        List<CursoDTO> listaFiltrada = new ArrayList<>();
        for (CursoDTO actual : lista) {
            if (!actual.getCreditos().equals(creditos)) continue;
            listaFiltrada.add(actual);
        }

        return listaFiltrada;
    }

}
