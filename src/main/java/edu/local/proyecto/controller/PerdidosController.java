package edu.local.proyecto.controller;

import edu.local.proyecto.dao.entity.PerdidoEntity;
import edu.local.proyecto.service.PerdidoService;

import java.util.Calendar;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@Slf4j
public class PerdidosController {
    
    @Autowired
    private PerdidoService perdidoService;
    
    @RequestMapping("objetoListar")
    public ModelAndView mostrarObjetosPerdidos() {
        log.debug("Listando los objetos perdidos");
        ModelAndView mv = new ModelAndView("objetosPerdidos", "lista", perdidoService.listarTodos());
        mv.addObject("perdidoBean",new PerdidoEntity());
        return mv;
    }
    
    @RequestMapping("objetoGrabar")
    public ModelAndView grabarObjetoPerdido(PerdidoEntity ce) {
        log.debug("Antes de guardar Objeto Perdido");
        perdidoService.insertar(ce);
        log.info("Objeto Perdido guardado");
        return new ModelAndView("redirect:objetoListar");
    }

    @RequestMapping("objetoEliminar")
    public ModelAndView eliminarObjetoPerdido(@RequestParam int codigo) {
        log.debug("Antes de eliminar Objeto Perdido");
        perdidoService.eliminar(codigo);
        log.info("Se elimino objeto perdido");
        return new ModelAndView("redirect:objetoListar");
    }
    
    @RequestMapping("objetoEncontrado")
    public ModelAndView encontrarObjetoPerdido(@RequestParam int codigo) {
        
        log.debug("Antes de marcar objeto como encontrado");
        PerdidoEntity encontrar = perdidoService.obtenerUno(codigo);
        Date today = new Date(Calendar.getInstance().getTimeInMillis());
        encontrar.setFechaRecuperacion(today);
        perdidoService.insertar(encontrar);
        log.info("Marcado objeto como encontrado");
        return new ModelAndView("redirect:objetoListar");
    }
    
    @RequestMapping("objetoEditar")
    public ModelAndView editarObjetoPerdido(@RequestParam int codigo){
        log.debug("Direccionando a pagina de edicion de objetos");
        ModelAndView mv = new ModelAndView("edicionObjeto");
        PerdidoEntity buscado = perdidoService.obtenerUno(codigo);
        mv.addObject("perdidoBean", buscado);
        return mv;
    }
    
    @RequestMapping("objetoEditado")
    public ModelAndView cambiarValoresObjetoPerdido(PerdidoEntity pe, 
            @RequestParam String recuperacion){
        log.debug("Antes de editar objeto perdido");
        if(recuperacion.equals("")){
            pe.setFechaRecuperacion(null);
        }
        else{
            try{
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fechaUtil = format.parse(recuperacion);
                pe.setFechaRecuperacion(new Date(fechaUtil.getTime()));
            } catch(ParseException e){
                pe.setFechaRecuperacion(null);
            }
        }

        perdidoService.insertar(pe);
        log.info("Objeto perdido editado");
        return new ModelAndView("redirect:objetoListar");
    }
    
    
}
