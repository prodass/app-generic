package com.biblioteca.model;

import com.biblioteca.constant.GenericConstant;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = GenericConstant.TAB_NAME_EDITORIAL, schema = GenericConstant.SCHEMA_NAME)
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Long idEditorial;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "estado")
    private String estado;
}
