package org.educationinusa.university.model.findapartner.profile;

import org.educationinusa.university.extra.enums.RoleEnum;
import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;

import java.util.List;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String nickName;
    private String password;
    private String universityName;
    private String major;
    private Long year;
    private Long intake;
    private Boolean sharePhoneNumber;
    private Boolean shareOnlyNickName;
    private Long rowStatus;
    private String jwt;
    private List<InterviewDetails> interviewDetails;
    private List<InterviewTravelPartner> interviewTravelPartners;
    private List<RoleEnum> roles;
    private Boolean emailAlreadyExists;
    private Boolean phoneNumberAlreadyExists;

    public User() {
    }

    public User(Long id) {
        this.id = id;
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

    public Long getIntake() {
        return intake;
    }

    public void setIntake(Long intake) {
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

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    public List<InterviewDetails> getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(List<InterviewDetails> interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public List<InterviewTravelPartner> getVisaInterviewTravelPartners() {
        return interviewTravelPartners;
    }

    public void setVisaInterviewTravelPartners(List<InterviewTravelPartner> interviewTravelPartners) {
        this.interviewTravelPartners = interviewTravelPartners;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public List<InterviewTravelPartner> getInterviewTravelPartners() {
        return interviewTravelPartners;
    }

    public void setInterviewTravelPartners(List<InterviewTravelPartner> interviewTravelPartners) {
        this.interviewTravelPartners = interviewTravelPartners;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    public void setEmailAlreadyExists(Boolean emailAlreadyExists) {
        this.emailAlreadyExists = emailAlreadyExists;
    }

    public void setPhoneNumberAlreadyExists(Boolean phoneNumberAlreadyExists) {
        this.phoneNumberAlreadyExists = phoneNumberAlreadyExists;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEmailAlreadyExists() {
        return emailAlreadyExists;
    }

    public Boolean getPhoneNumberAlreadyExists() {
        return phoneNumberAlreadyExists;
    }
}
