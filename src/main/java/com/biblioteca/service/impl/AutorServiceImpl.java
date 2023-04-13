package com.biblioteca.service.impl;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.model.Autor;
import com.biblioteca.repository.IAutorRepository;
import com.biblioteca.service.IAutorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements IAutorService{

    final IAutorRepository autorRepository;

    public AutorServiceImpl(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    
    @Override
    public List<AutorDTO> buscar(String buscar) {
        List<Autor> listadoAutores = this.autorRepository.listarByParam(buscar);
        List<AutorDTO> listadoAutoresDTO = new ArrayList<>();
        listadoAutores.forEach((bean) -> {
            AutorDTO autorDTO = new AutorDTO();
            autorDTO.setIdAutor(bean.getIdAutor());
            autorDTO.setNombre(bean.getNombre());
            autorDTO.setApellido(bean.getApellido());
            listadoAutoresDTO.add(autorDTO);
        });
        
        return listadoAutoresDTO;
    }

    @Override
    public List<AutorDTO> findAll() {
        List<Autor> listadoAutores = this.autorRepository.findAll();
        List<AutorDTO> listadoAutoresDTO = new ArrayList<>();
        listadoAutores.forEach((bean) -> {
            AutorDTO autorDTO = new AutorDTO();
            autorDTO.setIdAutor(bean.getIdAutor());
            autorDTO.setNombre(bean.getNombre());
            autorDTO.setApellido(bean.getApellido());
            listadoAutoresDTO.add(autorDTO);
        });
        return listadoAutoresDTO;
    }
}
