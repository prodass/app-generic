package com.biblioteca.dto;

import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageableDTO implements Pageable {
    private Integer page;
    private Integer size;
    private Optional<Integer> order;
    private Optional<String> field;

    public Optional<Integer> getOrder() {
        return order;
    }

    public Optional<String> getField() {
        return field;
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
