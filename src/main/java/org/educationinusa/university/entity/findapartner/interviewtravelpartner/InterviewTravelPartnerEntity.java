package org.educationinusa.university.entity.findapartner.interviewtravelpartner;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.entity.geography.StateEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "InterviewTravelPartner")
@EntityListeners(AuditingEntityListener.class)
public class InterviewTravelPartnerEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TravelFromStateID")
    private StateEntity travelFromState;

    @Column(name = "TravelFromCity")
    private String travelFromCity;

    @Column(name = "TravelPartnerRequired")
    private Boolean travelPartnerRequired;

    @Column(name = "HasTravelPartner")
    private Boolean hasTravelPartner;

    @Column(name = "TravelDate")
    private Instant travelDate;

    @Column(name = "Comments")
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenderPreferenceID")
    private LookupConfigurationEntity genderPreference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RowStatus")
    private RowStatusEntity rowStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InterviewDetailsID")
    private InterviewDetailsEntity interviewDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private UserEntity user;

    public InterviewTravelPartnerEntity() {
    }

    public InterviewTravelPartnerEntity(Long id) {
        this.id = id;
    }

    public InterviewTravelPartnerEntity(Long id, StateEntity travelFromState, String travelFromCity,
                                        Boolean travelPartnerRequired, Boolean hasTravelPartner, Instant travelDate,
                                        String comments, LookupConfigurationEntity genderPreference,
                                        RowStatusEntity rowStatus, InterviewDetailsEntity interviewDetails,
                                        UserEntity user) {
        this.id = id;
        this.travelFromState = travelFromState;
        this.travelFromCity = travelFromCity;
        this.travelPartnerRequired = travelPartnerRequired;
        this.hasTravelPartner = hasTravelPartner;
        this.travelDate = travelDate;
        this.comments = comments;
        this.genderPreference = genderPreference;
        this.rowStatus = rowStatus;
        this.interviewDetails = interviewDetails;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StateEntity getTravelFromState() {
        return travelFromState;
    }

    public void setTravelFromState(StateEntity travelFromState) {
        this.travelFromState = travelFromState;
    }

    public String getTravelFromCity() {
        return travelFromCity;
    }

    public void setTravelFromCity(String travelFromCity) {
        this.travelFromCity = travelFromCity;
    }

    public Boolean getTravelPartnerRequired() {
        return travelPartnerRequired;
    }

    public void setTravelPartnerRequired(Boolean travelPartnerRequired) {
        this.travelPartnerRequired = travelPartnerRequired;
    }

    public Boolean getHasTravelPartner() {
        return hasTravelPartner;
    }

    public void setHasTravelPartner(Boolean hasTravelPartner) {
        this.hasTravelPartner = hasTravelPartner;
    }

    public Instant getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Instant travelDate) {
        this.travelDate = travelDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LookupConfigurationEntity getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(LookupConfigurationEntity genderPreference) {
        this.genderPreference = genderPreference;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public InterviewDetailsEntity getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(InterviewDetailsEntity interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity User) {
        this.user = User;
    }
}
