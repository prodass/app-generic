package com.biblioteca.mapper;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.model.Autor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T20:09:11-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class IAutorMapperImpl implements IAutorMapper {

    @Override
    public AutorDTO toDto(Autor autor) {
        if ( autor == null ) {
            return null;
        }

        AutorDTO autorDTO = new AutorDTO();

        autorDTO.setId( autor.getId() );
        autorDTO.setApellido( autor.getApellido() );

        autorDTO.setNombre( autor.getNombre().concat(" ").concat(autor.getApellido()) );

        return autorDTO;
    }
}
