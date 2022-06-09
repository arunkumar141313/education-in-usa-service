package org.educationinusa.university.repository.finaapartner.userdetails;

import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

public interface InterviewTravelPartnerRepository extends
        PagingAndSortingRepository<InterviewTravelPartnerEntity, Long>,
        JpaRepository<InterviewTravelPartnerEntity, Long> {


    @Query(value = "SELECT * FROM InterviewTravelPartner ITP INNER JOIN InterviewDetails ID ON ID.ID = ITP.InterviewDetailsID" +
            " WHERE ITP.UserID = ?1 AND ITP.RowStatus IN(?2) AND ID.RowStatus = 1", nativeQuery = true)
    List<InterviewTravelPartnerEntity> findAllByUserId(Long userId, List<Long> rowStatus);


    @Query(value = """
            SELECT ITP.* FROM DEV_University.InterviewTravelPartner ITP
            INNER JOIN DEV_University.InterviewDetails ID ON ID.ID = ITP.InterviewDetailsID
            WHERE ITP.TravelPartnerRequired = 1 AND ITP.GenderPreferenceID IN (?1)
            AND ITP.RowStatus = 1 AND ID.RowStatus = 1 AND ID.InterviewStatusID IN(18, 20) AND ITP.UserID NOT IN (?2) AND ITP.TravelFromStateID = ?3
            AND DATE(convert_tz(ID.InterviewDate,'+05:30','+00:00')) = DATE(convert_tz(?4,'+05:30','+00:00'))""", nativeQuery = true)
    List<InterviewTravelPartnerEntity> findPartnersForInterviewTravel(List<Long> genderPreferences, Long userId, Long stateId, Instant interviewDate);

    @Modifying
    @Transactional
    @Query(value = "UPDATE InterviewTravelPartner ITP SET ITP.HasTravelPartner = ?2, ITP.UpdatedBy=?2, ITP.UpdatedAt=now()  WHERE ID = ?1", nativeQuery = true)
    int updateHasTravelPartnerPreference( Boolean hasTravelPartner, Long updatedBy, Long interviewTravelPartnerId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE InterviewTravelPartner ITP SET ITP.TravelPartnerRequired = ?1, ITP.UpdatedBy=?2, ITP.UpdatedAt=now()  WHERE ID = ?3", nativeQuery = true)
    int updateTravelPartnerRequiredPreference(Boolean travelPartnerRequired, Long updatedBy, Long interviewTravelPartnerId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE InterviewTravelPartner ITP SET ITP.RowStatus = 3, ITP.UpdatedBy=?1, ITP.UpdatedAt=now() WHERE ID = ?2", nativeQuery = true)
    int deleteInterviewTravelPartner(Long updatedBy  ,Long interviewTravelPartnerId);
}
