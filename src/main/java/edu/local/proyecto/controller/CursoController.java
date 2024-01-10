package edu.local.proyecto.controller;

import edu.local.proyecto.dto.CursoDTO;
import edu.local.proyecto.service.CursoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoListar")
    public ModelAndView mostrarCurso() {
        log.debug("Listando los cursos");
        ModelAndView mv = new ModelAndView("curso", "lista", cursoService.listarTodos());
        mv.addObject("cursoBean",new CursoDTO());
        return mv;
    }

    @RequestMapping("cursoGrabar")
    public ModelAndView grabarCurso(CursoDTO ce) {
        log.debug("Antes de insertar un curso");
        
        String facultad = ce.getFacultad();
        ce.setFacultad(facultad.equals("0") ? "Numeros" : "Letras");
        String modalidad = ce.getModalidad();
        ce.setModalidad(modalidad.equals("0") ? "Virtual" : "Presencial");
        
        cursoService.insertar(ce);
        log.info("Después de insertar un curso");
        return new ModelAndView("redirect:cursoListar");
    }

    @RequestMapping("cursoEliminar")
    public ModelAndView eliminarCurso(@RequestParam("codigo") int codigo) {
        log.debug("Antes de eliminar un curso");
        cursoService.eliminar(codigo);
        log.info("Después de eliminar un curso");
        return new ModelAndView("redirect:cursoListar");
    }
    
    @RequestMapping("cursoEditar")
    public ModelAndView editarCurso(@RequestParam("codigo") int codigo) {
        log.debug("Direccionando a pagina de edicion de cursos");
        ModelAndView mv = new ModelAndView("edicionCurso");
        CursoDTO buscado = cursoService.obtenerUno(codigo);
        mv.addObject("cursoBean", buscado);
        return mv;
    }
    
    @RequestMapping("cursoEditado")
    public ModelAndView cambiarValoresCurso(CursoDTO ce, @RequestParam int facultad,
            @RequestParam int modalidad){
        
        log.debug("Antes de editar curso");
        ce.setModalidad(modalidad == 0 ? "Virtual" : "Presencial");
        ce.setFacultad(facultad == 0 ? "Numeros" : "Letras");
        cursoService.modificar(ce);
        log.info("Curso editado");
        return new ModelAndView("redirect:cursoListar");
    }

}
