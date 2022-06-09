package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.RowStatusEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TimeZone")
@EntityListeners(AuditingEntityListener.class)
public class TimeZoneEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "offset")
    private Float offset;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RowStatus", referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    @OneToMany(mappedBy = "timeZone", fetch = FetchType.LAZY)
    private List<CountryEntity> countries;

    public TimeZoneEntity() {
    }

    public TimeZoneEntity(Long id) {
        this.id = id;
    }

    public TimeZoneEntity(Long id, String name, Float offset, RowStatusEntity rowStatus, List<CountryEntity> countries) {
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

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<CountryEntity> getCountries() {
        return countries;
    }

    public void setCountries(List<CountryEntity> countries) {
        this.countries = countries;
    }
}
