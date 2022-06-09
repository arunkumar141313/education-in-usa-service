package org.educationinusa.university.entity;

import org.educationinusa.university.entity.faq.FaqEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LookupConfiguration")
public class LookupConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "Group", nullable = false)
    private String group;

    @Column(name = "Key", nullable = false)
    private String key;

    @Column(name = "Value")
    private String value;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    @OneToMany(mappedBy = "faqType")
    private List<FaqEntity> faqTypes;

    @OneToMany(mappedBy = "verificationStatus")
    private List<FaqEntity> verificationStatuses;

    @OneToMany(mappedBy = "interviewType", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewDetails;

    @OneToMany(mappedBy = "genderPreference", fetch = FetchType.LAZY)
    private List<InterviewTravelPartnerEntity> genderPreference;

    @OneToMany(mappedBy = "interviewStatus", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewStatus;

    @OneToMany(mappedBy = "intake", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    public LookupConfigurationEntity() {
    }

    public LookupConfigurationEntity(Long id) {
        this.id = id;
    }

    public LookupConfigurationEntity(Long id, String group, String key, String value, String description,
                                     RowStatusEntity rowStatus, List<FaqEntity> faqTypes,
                                     List<FaqEntity> verificationStatuses, List<InterviewDetailsEntity> interviewDetails,
                                     List<InterviewTravelPartnerEntity> genderPreference,
                                     List<InterviewDetailsEntity> interviewStatus) {
        this.id = id;
        this.group = group;
        this.key = key;
        this.value = value;
        this.description = description;
        this.rowStatus = rowStatus;
        this.faqTypes = faqTypes;
        this.verificationStatuses = verificationStatuses;
        this.interviewDetails = interviewDetails;
        this.genderPreference = genderPreference;
        this.interviewStatus = interviewStatus;
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

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<FaqEntity> getFaqTypes() {
        return faqTypes;
    }

    public void setFaqTypes(List<FaqEntity> faqTypes) {
        this.faqTypes = faqTypes;
    }

    public List<FaqEntity> getVerificationStatuses() {
        return verificationStatuses;
    }

    public void setVerificationStatuses(List<FaqEntity> verificationStatuses) {
        this.verificationStatuses = verificationStatuses;
    }

    public List<InterviewDetailsEntity> getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(List<InterviewDetailsEntity> interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public List<InterviewTravelPartnerEntity> getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(List<InterviewTravelPartnerEntity> genderPreference) {
        this.genderPreference = genderPreference;
    }

    public List<InterviewDetailsEntity> getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(List<InterviewDetailsEntity> interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
