package com.biblioteca.service.impl;

import com.biblioteca.dto.AutorDTO;
import com.biblioteca.mapper.IAutorMapper;
import com.biblioteca.model.Autor;
import com.biblioteca.repository.IAutorRepository;
import com.biblioteca.service.IAutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements IAutorService{

    final IAutorRepository autorRepository;

    final IAutorMapper autorMapper;

    public AutorServiceImpl(IAutorRepository autorRepository, IAutorMapper autorMapper) {

        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }
    
    @Override
    public List<AutorDTO> buscar(String buscar) {
        List<Autor> listadoAutores = this.autorRepository.listarByParam(buscar);

        return listadoAutores
                .stream()
                .map((bean) -> this.autorMapper.toDto(bean))
                .collect(Collectors.toList());
    }

    @Override
    public Page<AutorDTO> findAll(Pageable pageable) {
        Page<Autor> listadoAutores = this.autorRepository.findAll(pageable);
        return listadoAutores
                .map((bean) -> this.autorMapper.toDto(bean));
    }


}
