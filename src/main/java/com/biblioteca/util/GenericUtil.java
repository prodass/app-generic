package com.biblioteca.util;


import com.biblioteca.dto.PageableDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public final class GenericUtil {
    public Pageable getPageable(PageableDTO pageableDTO) {
        Optional<Integer> sortOrder = pageableDTO.getOrder();
        Optional<String> sortField = pageableDTO.getField();
        int pageNumber = pageableDTO.getPageNumber();
        int perPage = pageableDTO.getPageSize();

        Pageable pageable;
        if (sortOrder.isPresent() && sortField.isPresent()) {
            Sort.Direction direction = sortOrder.get().equals(1) ? Sort.Direction.ASC : Sort.Direction.DESC;
            pageable = PageRequest.of(pageNumber, perPage, Sort.by(direction, sortField.get()));
        } else {
            pageable = PageRequest.of(pageNumber, perPage, Sort.by(Sort.Direction.DESC, "id"));
        }
        return pageable;
    }
}
