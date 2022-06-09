package org.educationinusa.university.model.geography;

import java.util.List;

public class Country {
    private Long id;
    private String name;
    private String isoCodeThree;
    private String isoCodeTwo;
    private TimeZone timeZone;
    private List<State> states;
    private Long rowStatus;

    public Country() {
    }

    public Country(Long id, String name, String isoCodeThree, String isoCodeTwo, TimeZone timeZone,
                   List<State> states, Long rowStatus) {
        this.id = id;
        this.name = name;
        this.isoCodeThree = isoCodeThree;
        this.isoCodeTwo = isoCodeTwo;
        this.timeZone = timeZone;
        this.states = states;
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

    public String getIsoCodeThree() {
        return isoCodeThree;
    }

    public void setIsoCodeThree(String isoCodeThree) {
        this.isoCodeThree = isoCodeThree;
    }

    public String getIsoCodeTwo() {
        return isoCodeTwo;
    }

    public void setIsoCodeTwo(String isoCodeTwo) {
        this.isoCodeTwo = isoCodeTwo;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isoCodeThree='" + isoCodeThree + '\'' +
                ", isoCodeTwo='" + isoCodeTwo + '\'' +
                ", timeZone=" + timeZone +
                ", states=" + states +
                ", rowStatus=" + rowStatus +
                '}';
    }
}
