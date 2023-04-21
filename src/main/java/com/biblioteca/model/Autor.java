package com.biblioteca.model;

import com.biblioteca.constant.GenericConstant;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = GenericConstant.TAB_NAME_AUTOR, schema = GenericConstant.SCHEMA_NAME)
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "estado")
    private String estado;
}
 