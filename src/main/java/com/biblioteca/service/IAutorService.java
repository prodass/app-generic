package com.biblioteca.service;

import com.biblioteca.dto.AutorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAutorService {
    public Page<AutorDTO> findAll(Pageable pageable);
    public List<AutorDTO> buscar(String buscar);
}
