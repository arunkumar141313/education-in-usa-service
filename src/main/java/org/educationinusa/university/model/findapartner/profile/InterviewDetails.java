package org.educationinusa.university.model.findapartner.profile;

import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;

import java.time.Instant;
import java.util.List;

public class InterviewDetails {
    private Long id;
    private Long embassy;
    private Instant interviewDate;
    private Long interviewType;
    private Long interviewStatus;
    private Long rowStatus;
    private String comments;
    private User user;
    private List<InterviewTravelPartner> interviewTravelPartners;

    public InterviewDetails() {
    }

    public InterviewDetails(Long id) {
        this.id = id;
    }

    public InterviewDetails(Long id, Long embassy, Instant interviewDate, Long interviewType, Long interviewStatus,
                            Long rowStatus, String comments, User user,
                            List<InterviewTravelPartner> interviewTravelPartners) {
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

    public Long getEmbassy() {
        return embassy;
    }

    public void setEmbassy(Long embassy) {
        this.embassy = embassy;
    }

    public Instant getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Instant interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Long getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(Long interviewType) {
        this.interviewType = interviewType;
    }

    public Long getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(Long interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<InterviewTravelPartner> getVisaInterviewTravelPartners() {
        return interviewTravelPartners;
    }

    public void setVisaInterviewTravelPartners(List<InterviewTravelPartner> interviewTravelPartners) {
        this.interviewTravelPartners = interviewTravelPartners;
    }
}
