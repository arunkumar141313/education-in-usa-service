package org.educationinusa.university.model;

public class RowStatus {
    private Long id;
    private String name;

    public RowStatus() {
    }

    public RowStatus(Long id) {
        this.id = id;
    }

    public RowStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
