package edu.local.proyecto.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class UsuarioEntity {

    @Id
    private String usuario;
    private String clave;
}
