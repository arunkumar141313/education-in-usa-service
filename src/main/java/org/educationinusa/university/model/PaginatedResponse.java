package org.educationinusa.university.model;

import java.util.List;

public class PaginatedResponse<T> {

    private int page = 0;
    private int size = 0;
    private long elements = 0;
    private long totalElements = 0;
    private int totalPages = 0;
    private List<SortingOrder> sort;
    private T data;

    public PaginatedResponse() {
    }

    public PaginatedResponse(int page, int size, long elements, long totalElements, int totalPages, List<SortingOrder> sort, T data) {
        this.page = page;
        this.size = size;
        this.elements = elements;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.sort = sort;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getElements() {
        return elements;
    }

    public void setElements(long elements) {
        this.elements = elements;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<SortingOrder> getSort() {
        return sort;
    }

    public void setSort(List<SortingOrder> sort) {
        this.sort = sort;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
