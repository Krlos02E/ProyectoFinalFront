package edu.local.proyecto.dao.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "auditoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idauditoria")
    private Integer idAuditoria;
    
    @Column(name = "nombreservicio")
    private String nombreServicio;
    
    @Column(name = "diaservicio")
    @Temporal(TemporalType.DATE)
    private Date diaServicio;
    
    private String operacion;
    
    @Column(name = "fechahora", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoOperacion;
    
}