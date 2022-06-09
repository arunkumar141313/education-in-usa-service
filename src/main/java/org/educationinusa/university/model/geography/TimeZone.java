package org.educationinusa.university.model.geography;

import java.util.List;

public class TimeZone {
    private Long id;
    private String name;
    private Float offset;
    private Long rowStatus;
    private List<Country> countries;

    public TimeZone() {
    }

    public TimeZone(Long id, String name, Float offset, Long rowStatus, List<Country> countries) {
        this.id = id;
        this.name = name;
        this.offset = offset;
        this.rowStatus = rowStatus;
        this.countries = countries;
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

    public Float getOffset() {
        return offset;
    }

    public void setOffset(Float offset) {
        this.offset = offset;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "TimeZone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", offset=" + offset +
                ", rowStatus=" + rowStatus +
                ", countries=" + countries +
                '}';
    }
}
