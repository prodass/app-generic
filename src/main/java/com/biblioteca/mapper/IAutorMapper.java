package com.biblioteca.mapper;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.model.Autor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(builder = @Builder(disableBuilder = true))
public interface IAutorMapper {
    @Mapping(target = "nombre",expression = "java(autor.getNombre().concat(\" \").concat(autor.getApellido()))")
    public AutorDTO toDto(Autor autor);
}
