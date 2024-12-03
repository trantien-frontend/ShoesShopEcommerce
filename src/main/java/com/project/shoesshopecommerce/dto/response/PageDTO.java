package com.project.shoesshopecommerce.dto.response;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageDTO<T> {
    List<T> products;
    int pageNumber;
    int pageSize;
    long totalElements;

    public PageDTO(Page<T> page) {
        this.products = page.getContent();
        this.pageSize = page.getSize();
        this.pageNumber = page.getPageable().getPageNumber() + 1;
        this.totalElements = page.getTotalElements();
    }
}
