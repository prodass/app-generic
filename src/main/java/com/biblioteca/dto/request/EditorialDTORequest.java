package com.biblioteca.dto.request;


import javax.validation.constraints.*;
import lombok.Data;

@Data
public class EditorialDTORequest {
    //Validacion de atributos.
    
    @NotNull
    @NotEmpty
    @NotBlank
    
    @Size(min = 5,max = 100)
    private String nombre;
}
