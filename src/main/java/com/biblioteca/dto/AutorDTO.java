package com.biblioteca.dto;

import java.io.Serializable;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO implements Serializable{

    private Long idAutor;
    private String nombre;
    private String apellido;
}
