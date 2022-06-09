package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.RowStatusEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Country")
@EntityListeners(AuditingEntityListener.class)
public class CountryEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "isoCodeThree")
    private String isoCodeThree;

    @Column(name = "isoCodeTwo")
    private String isoCodeTwo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TimeZone", nullable = false, referencedColumnName = "ID")
    private TimeZoneEntity timeZone;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StateEntity> states;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<EmbassyEntity> embassies;

    public CountryEntity() {
    }

    public CountryEntity(Long id) {
        this.id = id;
    }

    public CountryEntity(Long id, String name, String url, String isoCodeThree, String isoCodeTwo, TimeZoneEntity timeZone,
                         RowStatusEntity rowStatus, List<StateEntity> states) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.isoCodeThree = isoCodeThree;
        this.isoCodeTwo = isoCodeTwo;
        this.timeZone = timeZone;
        this.rowStatus = rowStatus;
        this.states = states;
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

    public TimeZoneEntity getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZoneEntity timeZone) {
        this.timeZone = timeZone;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<StateEntity> getStates() {
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<EmbassyEntity> getEmbassies() {
        return embassies;
    }

    public void setEmbassies(List<EmbassyEntity> embassies) {
        this.embassies = embassies;
    }
}
