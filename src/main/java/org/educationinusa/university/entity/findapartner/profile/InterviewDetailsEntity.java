package org.educationinusa.university.entity.findapartner.profile;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "InterviewDetails")
@EntityListeners(AuditingEntityListener.class)
public class InterviewDetailsEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmbassyID")
    private EmbassyEntity embassy;

    @Column(name = "InterviewDate")
    private Instant interviewDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InterviewTypeID")
    private LookupConfigurationEntity interviewType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InterviewStatusID")
    private LookupConfigurationEntity interviewStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RowStatus")
    private RowStatusEntity rowStatus;

    @Column(name = "Comments")
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private UserEntity user;

    @OneToMany(mappedBy = "interviewDetails", fetch = FetchType.LAZY)
    private List<InterviewTravelPartnerEntity> interviewTravelPartners;

    public InterviewDetailsEntity() {
    }

    public InterviewDetailsEntity(Long id) {
        this.id = id;
    }

    public InterviewDetailsEntity(Long id, EmbassyEntity embassy, Instant interviewDate,
                                  LookupConfigurationEntity interviewType, LookupConfigurationEntity interviewStatus,
                                  RowStatusEntity rowStatus, String comments, UserEntity user,
                                  List<InterviewTravelPartnerEntity> interviewTravelPartners) {
        this.id = id;
        this.embassy = embassy;
        this.interviewDate = interviewDate;
        this.interviewType = interviewType;
        this.interviewStatus = interviewStatus;
        this.rowStatus = rowStatus;
        this.comments = comments;
        this.user = user;
        this.interviewTravelPartners = interviewTravelPartners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmbassyEntity getEmbassy() {
        return embassy;
    }

    public void setEmbassy(EmbassyEntity embassy) {
        this.embassy = embassy;
    }

    public Instant getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Instant interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LookupConfigurationEntity getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(LookupConfigurationEntity interviewType) {
        this.interviewType = interviewType;
    }

    public LookupConfigurationEntity getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(LookupConfigurationEntity interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<InterviewTravelPartnerEntity> getInterviewTravelPartners() {
        return interviewTravelPartners;
    }

    public void setInterviewTravelPartners(List<InterviewTravelPartnerEntity> interviewTravelPartners) {
        this.interviewTravelPartners = interviewTravelPartners;
    }
}
