package com.biblioteca.service.impl;

import com.biblioteca.constant.GenericConstant;
import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.dto.request.EditorialDTORequest;
import com.biblioteca.mapper.IEditorialMapper;
import com.biblioteca.model.Editorial;
import com.biblioteca.repository.IEditorialRepository;
import com.biblioteca.service.IEditorialService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements IEditorialService{

    final IEditorialRepository editorialRepository;

    final IEditorialMapper editorialMapper;

    public EditorialServiceImpl(IEditorialRepository editorialRepository, IEditorialMapper editorialMapper) {
        this.editorialRepository = editorialRepository;
        this.editorialMapper = editorialMapper;
    }

    @Override
    public Page<EditorialDTO> findAll(Pageable pageable) {
        Page<Editorial> listadoEditoriales = this.editorialRepository.findAll(pageable);
        return listadoEditoriales.map((bean) -> editorialMapper.toDto(bean));
    }

    @Override
    public EditorialDTO save(EditorialDTORequest editorialReq) {
        return this.editorialMapper.toDto(this.editorialRepository.save(
                Editorial.builder()
                    .nombre(editorialReq.getNombre())
                    .estado(GenericConstant.STATE_ACTIVE)
                    .build()
                ));
    }

    @Override
    public EditorialDTO update(EditorialDTORequest editorialReq, Long idEditorial) {
        Optional<Editorial> editorialOpt = this.editorialRepository.findById(idEditorial);
        Editorial editorial = editorialOpt.get();
        editorial.setNombre(editorialReq.getNombre());
        return this.editorialMapper.toDto(this.editorialRepository.save(editorial));
    }
    
    @Override
    public void delete(Long idEditorial) {
        Optional<Editorial> editorialOpt = this.editorialRepository.findById(idEditorial);
        Editorial editorial = editorialOpt.get();
        editorial.setEstado(GenericConstant.STATE_INACTIVE);
        this.editorialRepository.save(editorial);
    }
}
