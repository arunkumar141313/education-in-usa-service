package org.educationinusa.university.entity.findapartner.profile;

import org.educationinusa.university.entity.Auditable;
import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "NickName")
    private String nickName;

    @Column(name = "Password")
    private String password;

    @Column(name = "UniversityName")
    private String universityName;

    @Column(name = "Major")
    private String major;

    @Column(name = "Year")
    private Long year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IntakeID")
    private LookupConfigurationEntity intake;

    @Column(name = "SharePhoneNumber")
    private Boolean sharePhoneNumber = false;

    @Column(name = "ShareOnlyNickName")
    private Boolean shareOnlyNickName = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RowStatus")
    private RowStatusEntity rowStatus;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewDetails;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewDetailsCreatedBy;

    @OneToMany(mappedBy = "updatedBy", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewDetailsUpdatedBy;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InterviewTravelPartnerEntity> interviewTravelPartners;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserRoleEntity> userRoles = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Long id) {
        this.id = id;
    }

    public UserEntity(Long id, String firstName, String lastName, String email, String phoneNumber, String nickName, String password, String universityName, String major, Long year, LookupConfigurationEntity intake, Boolean sharePhoneNumber, Boolean shareOnlyNickName, RowStatusEntity rowStatus, List<InterviewDetailsEntity> interviewDetails, List<InterviewTravelPartnerEntity> interviewTravelPartners, List<UserRoleEntity> userRoles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nickName = nickName;
        this.password = password;
        this.universityName = universityName;
        this.major = major;
        this.year = year;
        this.intake = intake;
        this.sharePhoneNumber = sharePhoneNumber;
        this.shareOnlyNickName = shareOnlyNickName;
        this.rowStatus = rowStatus;
        this.interviewDetails = interviewDetails;
        this.interviewTravelPartners = interviewTravelPartners;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public LookupConfigurationEntity getIntake() {
        return intake;
    }

    public void setIntake(LookupConfigurationEntity intake) {
        this.intake = intake;
    }

    public Boolean getSharePhoneNumber() {
        return sharePhoneNumber;
    }

    public void setSharePhoneNumber(Boolean sharePhoneNumber) {
        this.sharePhoneNumber = sharePhoneNumber;
    }

    public Boolean getShareOnlyNickName() {
        return shareOnlyNickName;
    }

    public void setShareOnlyNickName(Boolean shareOnlyNickName) {
        this.shareOnlyNickName = shareOnlyNickName;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<InterviewDetailsEntity> getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(List<InterviewDetailsEntity> interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public List<InterviewTravelPartnerEntity> getInterviewTravelPartners() {
        return interviewTravelPartners;
    }

    public void setInterviewTravelPartners(List<InterviewTravelPartnerEntity> interviewTravelPartners) {
        this.interviewTravelPartners = interviewTravelPartners;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public List<InterviewDetailsEntity> getInterviewDetailsCreatedBy() {
        return interviewDetailsCreatedBy;
    }

    public void setInterviewDetailsCreatedBy(List<InterviewDetailsEntity> interviewDetailsCreatedBy) {
        this.interviewDetailsCreatedBy = interviewDetailsCreatedBy;
    }

    public List<InterviewDetailsEntity> getInterviewDetailsUpdatedBy() {
        return interviewDetailsUpdatedBy;
    }

    public void setInterviewDetailsUpdatedBy(List<InterviewDetailsEntity> interviewDetailsUpdatedBy) {
        this.interviewDetailsUpdatedBy = interviewDetailsUpdatedBy;
    }


}
