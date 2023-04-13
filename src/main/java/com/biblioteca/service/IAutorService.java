package com.biblioteca.service;

import com.biblioteca.dto.AutorDTO;
import java.util.List;

public interface IAutorService {
    public List<AutorDTO> findAll();
    public List<AutorDTO> buscar(String buscar);
}
