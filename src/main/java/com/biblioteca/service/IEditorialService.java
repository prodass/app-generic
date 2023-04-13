package com.biblioteca.service;

import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.dto.request.EditorialDTORequest;
import java.util.List;

public interface IEditorialService {

    public List<EditorialDTO> findAll();

    public EditorialDTO save(EditorialDTORequest editorial);

    public EditorialDTO update(EditorialDTORequest editorialReq, Long idEditorial);
    
    public void delete(Long idEditorial);
 
}
