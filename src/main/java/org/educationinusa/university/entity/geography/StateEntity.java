package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "State")
@EntityListeners(AuditingEntityListener.class)
public class StateEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryID", referencedColumnName = "ID")
    private CountryEntity country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RowStatus", referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
    private List<EmbassyEntity> embassies;

    @OneToMany(mappedBy = "travelFromState", fetch = FetchType.LAZY)
    private List<InterviewTravelPartnerEntity> interviewDetails;

    public StateEntity() {
    }

    public StateEntity(Long id) {
        this.id = id;
    }

    public StateEntity(Long id, String name, CountryEntity country, RowStatusEntity rowStatus) {
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

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }
}
