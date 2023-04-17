package com.biblioteca.controller;

import com.biblioteca.constant.GenericConstant;
import com.biblioteca.dto.AutorDTO;
import com.biblioteca.service.IAutorService;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GenericConstant.RESOURCE_GENERIC)
@CrossOrigin("*")
public class AutorController {
    final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }
    
    @GetMapping(GenericConstant.RESOURCE_AUTORES + GenericConstant.RESOURCE_AUTORES_AUTOR)
    public List<AutorDTO> findByParam(@RequestParam String buscar){
        return this.autorService.buscar(buscar);
    }
    
    @GetMapping(GenericConstant.RESOURCE_AUTORES + GenericConstant.RESOURCE_AUTORES_AUTOR + GenericConstant.RESOURCE_GENERIC_LISTAR)
    public Page<AutorDTO> findAll(Pageable pageable){
        return this.autorService.findAll(pageable);
    }
}