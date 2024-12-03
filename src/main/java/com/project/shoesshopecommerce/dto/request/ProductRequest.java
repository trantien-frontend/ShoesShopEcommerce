package com.project.shoesshopecommerce.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    static final int DEFAULT_PAGE = 0;
    static final int DEFAULT_LIMIT = 5;
    static final String DEFAULT_SORT = "ASC";
    static final int MAX_LIMIT = 100;

    int page = DEFAULT_PAGE;
    int limit = DEFAULT_LIMIT;
    @Setter(AccessLevel.NONE)
    String sort;

    public ProductRequest (int _page, int _limit, String _sort) {
        page = Math.max(DEFAULT_PAGE, _page);
        limit = Math.min(Math.max(1, _limit),MAX_LIMIT);
        sort = validateAndGetSort(_sort);
    }

     String validateAndGetSort (String sort) {
        return sort == null || sort.trim().isEmpty() ? DEFAULT_SORT : sort;
    }

    public void setSort (String _sort) {
        this.sort = validateAndGetSort(_sort);
    }
}
