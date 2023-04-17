package com.biblioteca.service;

import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.dto.request.EditorialDTORequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEditorialService {

    public Page<EditorialDTO> findAll(Pageable pageable);

    public EditorialDTO save(EditorialDTORequest editorial);

    public EditorialDTO update(EditorialDTORequest editorialReq, Long idEditorial);
    
    public void delete(Long idEditorial);
 
}
