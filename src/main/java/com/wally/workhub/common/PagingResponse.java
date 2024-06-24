package com.wally.workhub.common;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PagingResponse<T> {

    private final long page;
    private final long size;
    private final long totalCount;
    private final List<T> items;

    public PagingResponse(Page<?> page, Class<T> clazz) {
        this.page = page.getNumber() + 1;
        this.size = page.getSize();
        this.totalCount = page.getTotalElements();
        this.items = page.getContent().stream()
                .map(content -> {
                    try {
                        return clazz.getConstructor(content.getClass()).newInstance(content);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
