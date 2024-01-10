package edu.local.proyecto.controller;

import edu.local.proyecto.dto.CursoDTO;
import edu.local.proyecto.service.CursoService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class DetalleController {

    @Autowired
    private CursoService cursoService;

    private List<CursoDTO> listaFiltradaTotal;

    @RequestMapping("cursosDetalles")
    public ModelAndView mostrarDetalles(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("detallesCursos");
        String[] tipoConsulta = request.getParameterValues("checked");

        if (tipoConsulta == null || tipoConsulta.length == 0) {
            mv.addObject("lista", null);
            log.debug("Direccionando a la pagina de detalles");
            return mv;
        }

        List<CursoDTO> listaFiltrada = cursoService.listarTodos();
        log.info("Filtrando cursos");
        for (String consulta : tipoConsulta) {

            switch (consulta) {
                case "chkProfe":
                    String profesor = request.getParameter("profesor");
                    listaFiltrada = cursoService.filtrarPorProfesor(listaFiltrada, profesor);
                    break;
                case "chkModalidad":
                    String modalidad = request.getParameter("modalidad").equals("0") ? "Virtual" : "Presencial";
                    listaFiltrada = cursoService.filtrarPorModalidad(listaFiltrada, modalidad);
                    break;
                case "chkFacultad":
                    String facultad = request.getParameter("facultad").equals("0") ? "Numeros" : "Letras";
                    listaFiltrada = cursoService.filtrarPorFacultad(listaFiltrada, facultad);
                    break;
                case "chkCiclo":
                    Integer ciclo = Integer.valueOf(request.getParameter("ciclo"));
                    listaFiltrada = cursoService.filtrarPorCiclo(listaFiltrada, ciclo);
                    break;
                case "chkCreditos":
                    Double creditos = Double.valueOf(request.getParameter("creditos"));
                    listaFiltrada = cursoService.filtrarPorCreditos(listaFiltrada, creditos);
                    break;
            }
        }

        if (listaFiltrada.isEmpty()) {
            mv.addObject("lista", null);
            log.debug("Direccionando a la pagina de detalles");
            return mv;
        }
        
        listaFiltradaTotal = listaFiltrada;

        int tamMinimo = 4;
        if (listaFiltradaTotal.size() < tamMinimo) {
            tamMinimo = listaFiltradaTotal.size();
        }
        
        listaFiltrada = listaFiltrada.subList(0, tamMinimo);
        int ultimaPagina = listaFiltradaTotal.size() / 4 + ((listaFiltradaTotal.size() % 4 > 0) ? 1 : 0);

        mv.addObject("lista", listaFiltrada);
        mv.addObject("paginaActual", 1);
        mv.addObject("ultimaPagina", ultimaPagina);
        log.info("Direccionando a la pagina filtrada");
        return mv;
    }

    @RequestMapping("BuscarPagina")
    public ModelAndView buscarPagina(HttpServletRequest request,
            @RequestParam int page) {

        int listaSize = listaFiltradaTotal.size();
        int ultimaPagina = listaSize / 4 + (listaSize % 4 > 0 ? 1 : 0);
        int resultadosMostrar = 4;
        if (page == ultimaPagina && listaSize % 4 > 0) {
            resultadosMostrar = listaSize % 4;
        }
        int start = (page - 1) * 4;
        List<CursoDTO> listaPaginada = listaFiltradaTotal.subList(start, start + resultadosMostrar);
        ModelAndView mv = new ModelAndView("detallesCursos", "lista", listaPaginada);
        mv.addObject("paginaActual", page);
        mv.addObject("ultimaPagina", ultimaPagina);
        return mv;
    }

}
