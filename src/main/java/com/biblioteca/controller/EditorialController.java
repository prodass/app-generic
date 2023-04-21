package com.biblioteca.controller;

import com.biblioteca.constant.GenericConstant;
import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.dto.PageableDTO;
import com.biblioteca.dto.request.EditorialDTORequest;
import com.biblioteca.service.IEditorialService;

import java.util.List;

import com.biblioteca.util.GenericUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GenericConstant.RESOURCE_GENERIC)
@CrossOrigin("*")
public class EditorialController {
    final IEditorialService editorialService;
    final GenericUtil genericUtil;

    public EditorialController(IEditorialService editorialService, GenericUtil genericUtil) {
        this.editorialService = editorialService;
        this.genericUtil = genericUtil;
    }
    
    @GetMapping(GenericConstant.RESOURCE_EDITORIALES + GenericConstant.RESOURCE_EDITORIALES_EDITORIAL)
    public Page<EditorialDTO> findAll(PageableDTO pageable){
        return this.editorialService.findAll(this.genericUtil.getPageable(pageable));
    }
    
    @PostMapping(GenericConstant.RESOURCE_EDITORIALES + GenericConstant.RESOURCE_EDITORIALES_EDITORIAL)
    public EditorialDTO save(@RequestBody EditorialDTORequest editorial){
        return this.editorialService.save(editorial);
    }
    
    @PutMapping(GenericConstant.RESOURCE_EDITORIALES + GenericConstant.RESOURCE_EDITORIALES_EDITORIAL + GenericConstant.RESOURCE_GENERIC_ID)
    public EditorialDTO update(@RequestBody EditorialDTORequest editorialReq, @PathVariable Long id){
        return this.editorialService.update(editorialReq, id);
    }
    
    @DeleteMapping(GenericConstant.RESOURCE_EDITORIALES + GenericConstant.RESOURCE_EDITORIALES_EDITORIAL + GenericConstant.RESOURCE_GENERIC_ID)
    public void delete(@PathVariable Long id){
        this.editorialService.delete(id);
    }
}
