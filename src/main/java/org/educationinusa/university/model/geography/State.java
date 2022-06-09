package org.educationinusa.university.model.geography;

public class State {
    private Long id;
    private String name;
    private Country country;
    private Long rowStatus;

    public State() {
    }

    public State(Long id, String name, Country country,  Long rowStatus) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.rowStatus = rowStatus;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", rowStatus=" + rowStatus +
                '}';
    }
}
