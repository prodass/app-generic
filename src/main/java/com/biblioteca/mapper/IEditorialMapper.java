package com.biblioteca.mapper;

import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.model.Editorial;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface IEditorialMapper {
    public EditorialDTO toDto(Editorial editorial);
}