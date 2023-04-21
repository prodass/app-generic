package com.biblioteca.dto;

import java.io.Serializable;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditorialDTO implements Serializable{
    private Long id;
    private String nombre;
}
