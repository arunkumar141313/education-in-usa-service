package org.educationinusa.university.service.finaapartner.userdetails;

import org.educationinusa.university.model.findapartner.profile.InterviewDetails;

import java.util.List;

public interface InterviewDetailsService {
    InterviewDetails addInterviewDetails(Long userId, InterviewDetails interviewDetails);

    InterviewDetails updateInterviewDetails(Long interviewDetailsId, InterviewDetails interviewDetails);

    List<InterviewDetails> getByUserIdAndRowStatuses(Long userId, List<Long> rowStatuses);

    Boolean deleteInterviewDetails(List<Long> interviewDetailsId);
}
