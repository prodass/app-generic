package com.biblioteca.service.impl;

import com.biblioteca.constant.GenericConstant;
import com.biblioteca.dto.EditorialDTO;
import com.biblioteca.dto.request.EditorialDTORequest;
import com.biblioteca.model.Editorial;
import com.biblioteca.repository.IEditorialRepository;
import com.biblioteca.service.IEditorialService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements IEditorialService{

    final IEditorialRepository editorialRepository;

    public EditorialServiceImpl(IEditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }
    
    @Override
    public List<EditorialDTO> findAll() {
        List<Editorial> listadoEditoriales = this.editorialRepository.findAll();
        List<EditorialDTO> listadoEditorialesDTO = new ArrayList<>();
        listadoEditoriales.forEach((bean) -> {
            EditorialDTO editorialDTO = new EditorialDTO();
            editorialDTO.setIdEditorial(bean.getIdEditorial());
            editorialDTO.setNombre(bean.getNombre());
            listadoEditorialesDTO.add(editorialDTO);
        });
        
        return listadoEditorialesDTO;
    }

    @Override
    public EditorialDTO save(EditorialDTORequest editorialReq) {
        Editorial editorial = new Editorial();
        editorial.setNombre(editorialReq.getNombre());
        editorial.setEstado(GenericConstant.STATE_ACTIVE);
        return toDto(this.editorialRepository.save(editorial));
    }

    @Override
    public EditorialDTO update(EditorialDTORequest editorialReq, Long idEditorial) {
        Optional<Editorial> editorialOpt = this.editorialRepository.findById(idEditorial);
        Editorial editorial = editorialOpt.get();
        editorial.setNombre(editorialReq.getNombre());
        return toDto(this.editorialRepository.save(editorial));
    }
    
    @Override
    public void delete(Long idEditorial) {
        Optional<Editorial> editorialOpt = this.editorialRepository.findById(idEditorial);
        Editorial editorial = editorialOpt.get();
        editorial.setEstado(GenericConstant.STATE_INACTIVE);
        this.editorialRepository.save(editorial);
    }
    
    private EditorialDTO toDto(Editorial editorial){
        EditorialDTO editorialDTO = new EditorialDTO();
        editorialDTO.setIdEditorial(editorial.getIdEditorial());
        editorialDTO.setNombre(editorial.getNombre());
        return editorialDTO;
    }
}
