package edu.local.proyecto.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "servicio")
@Data
public class ServicioEntity {
    
    @Id
    @Column(name = "idservicio")
    private Integer idServicio;
    @Column(name = "nombreservicio")
    private String nombreServicio;
}
