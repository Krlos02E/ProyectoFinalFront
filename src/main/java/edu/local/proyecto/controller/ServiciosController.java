package edu.local.proyecto.controller;

import edu.local.proyecto.dao.entity.AuditoriaEntity;
import edu.local.proyecto.dao.entity.ReservaEntity;
import edu.local.proyecto.service.AuditoriaService;
import edu.local.proyecto.service.ReservaService;
import edu.local.proyecto.service.ServicioService;

import java.util.Date;
import java.util.Calendar;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ServiciosController {

    @Autowired
    private ServicioService servicioService;
    @Autowired
    private ReservaService reservaService;
    @Autowired
    private AuditoriaService auditoriaService;
    
    @RequestMapping("serviciosReservados")
    public ModelAndView mostrarReservas() {
        log.debug("Listando los servicios reservados");
        ModelAndView mv = new ModelAndView("servicios", "listaReservas", reservaService.listarTodos());
        mv.addObject("listaServicios", servicioService.listarTodos());
        mv.addObject("reservaBean",new ReservaEntity());
        log.info("Direccionando a la pagina de servicios");
        return mv;
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("reservaGrabar")
    public ModelAndView grabarReserva(@ModelAttribute("reservaBean") ReservaEntity re){
        
        log.debug("Antes de guardar una reserva");
        reservaService.insertar(re);
        log.info("Reserva Guardada");
        
        Date fechaReservada = re.getFechaServicio();
        Date today = new Date(Calendar.getInstance().getTimeInMillis());
        log.debug("Antes de Generar la auditoria");
        String servicioUsado = servicioService.listarTodos().get(re.getIdServicio() - 1).getNombreServicio();
        AuditoriaEntity ae = 
                new AuditoriaEntity(0, servicioUsado, fechaReservada , "Grabar Reserva", today);
        auditoriaService.insertar(ae);
        log.info("Auditoria Guardada");
        
        return new ModelAndView("redirect:serviciosReservados");
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("reservaEliminar")
    public ModelAndView eliminarReserva(@RequestParam("codigo") int codigo,
            @RequestParam("idxServicio") int idServicio) {
        
        log.debug("Antes de Generar la auditoria");
        String servicioUsado = servicioService.listarTodos().get(idServicio - 1).getNombreServicio();
        ReservaEntity old = reservaService.obtenerUno(codigo);
        Date fechaReservada = old.getFechaServicio();
        Date today = new Date(Calendar.getInstance().getTimeInMillis());
        String operacion = "Cancelar Reserva";
        if(fechaReservada.before(today)){
            operacion = "Quitar Reserva";
        }
        
        AuditoriaEntity ae = 
                new AuditoriaEntity(0, servicioUsado, fechaReservada, operacion, today);
        auditoriaService.insertar(ae);
        log.debug("Auditoria Generada");
        
        log.debug("Antes de eliminar una reserva");
        reservaService.eliminar(codigo);
        log.info("Reserva Cancelada");
        log.info("Auditoria Guardada");
        return new ModelAndView("redirect:serviciosReservados");
    }
    
    @RequestMapping("listaAuditorias")
    public ModelAndView listarAuditorias(){
        return new ModelAndView("auditoria", "lista", auditoriaService.listarTodas());
    }
    
}
