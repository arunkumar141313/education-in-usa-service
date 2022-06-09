package org.educationinusa.university.model;

public class LookupConfiguration {
    private Long id;
    private String group;
    private String key;
    private String value;
    private String description;
    private Long rowStatus;

    public LookupConfiguration() {
    }

    public LookupConfiguration(Long id, String group, String key, String value, String description, Long rowStatus) {
        this.id = id;
        this.group = group;
        this.key = key;
        this.value = value;
        this.description = description;
        this.rowStatus = rowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }
}
