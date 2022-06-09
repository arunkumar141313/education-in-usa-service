package org.educationinusa.university.model;

import org.springframework.data.domain.Sort;

public class SortingOrder {
    private Sort.Direction direction;
    private String name;

    public SortingOrder() {
    }

    public SortingOrder(Sort.Direction direction, String name) {
        this.direction = direction;
        this.name = name;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
