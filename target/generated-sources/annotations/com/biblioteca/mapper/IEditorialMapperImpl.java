package com.biblioteca.mapper;

import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.model.Editorial;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-21T20:09:11-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class IEditorialMapperImpl implements IEditorialMapper {

    @Override
    public EditorialDTO toDto(Editorial editorial) {
        if ( editorial == null ) {
            return null;
        }

        EditorialDTO editorialDTO = new EditorialDTO();

        editorialDTO.setId( editorial.getId() );
        editorialDTO.setNombre( editorial.getNombre() );

        return editorialDTO;
    }
}
