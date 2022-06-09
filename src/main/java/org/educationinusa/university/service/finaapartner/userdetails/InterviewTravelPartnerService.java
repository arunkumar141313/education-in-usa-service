package org.educationinusa.university.service.finaapartner.userdetails;

import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;

import java.util.List;

public interface InterviewTravelPartnerService {
    InterviewTravelPartner addInterviewTravelPartner(Long userId, Long interviewDetailsId,InterviewTravelPartner interviewTravelPartner);

    List<InterviewTravelPartner> getAllInterviewTravelPartnerPreferencesByUserId(Long userId, List<Long> rowStatus);

    List<InterviewTravelPartner> findPartnersForInterviewTravel(Long userId, Long interviewTravelPartnerId);

    Boolean changePartnerPreference(Long interviewTravelPartnerId, Boolean hasTravelPartner, Boolean travelPartnerRequired);

    Boolean deleteInterviewTravelPartner(Long interviewTravelPartnerId);

    InterviewTravelPartner updateInterviewTravelPartner(Long userId, Long interviewDetailsId, Long interviewTravelPartnerId, InterviewTravelPartner interviewTravelPartner);
}
