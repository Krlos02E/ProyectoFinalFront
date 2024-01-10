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
@Table(name = "objetoperdido")
@Data
public class PerdidoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperdido")
    private Integer idPerdido;
    private String descripcion;
    @Column(name = "fechaperdida")
    private Date fechaPerdida;
    @Column(name = "fecharecuperacion")
    private Date fechaRecuperacion;
    
}
