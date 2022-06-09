package org.educationinusa.university.model.findapartner.visainterviewtravel;

import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;

import java.time.Instant;

public class InterviewTravelPartner {
    private Long id;
    private Long travelFromState;
    private String travelFromCity;
    private Boolean travelPartnerRequired;
    private Boolean hasTravelPartner;
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant travelDate;
    private String comments;
    private Long genderPreference;
    private Long rowStatus;
    private InterviewDetails interviewDetails;
    private User user;

    public InterviewTravelPartner() {
    }

    public InterviewTravelPartner(Long id) {
        this.id = id;
    }

    public InterviewTravelPartner(Long id, Long travelFromState, String travelFromCity, Boolean travelPartnerRequired,
                                  Boolean hasTravelPartner, Instant travelDate, String comments, Long genderPreference,
                                  Long rowStatus, InterviewDetails interviewDetails, User user) {
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

    public Long getTravelFromState() {
        return travelFromState;
    }

    public void setTravelFromState(Long travelFromState) {
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

    public Long getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(Long genderPreference) {
        this.genderPreference = genderPreference;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    public InterviewDetails getInterviewDetails() {
        return interviewDetails;
    }

    public void setInterviewDetails(InterviewDetails interviewDetails) {
        this.interviewDetails = interviewDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
