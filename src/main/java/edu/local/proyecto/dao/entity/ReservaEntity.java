package edu.local.proyecto.dao.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "reservaservicio")
@Data
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Integer idReserva;
    @Column(name = "idservicio")
    private Integer idServicio;
    @Column(name = "fechaservicio")
    private Date fechaServicio;
    @Column(name = "totalalumnos")
    private Integer totalAlumnos;
    
}
