package org.educationinusa.university.repository.finaapartner.userdetails;

import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface InterviewDetailsRepository extends
        PagingAndSortingRepository<InterviewDetailsEntity, Long>,
        JpaRepository<InterviewDetailsEntity, Long> {

    @Query(value = "SELECT * FROM InterviewDetails ID Where ID.UserID=?1", nativeQuery = true)
    List<InterviewDetailsEntity> findAllByUserId(Long id);

    @Query(value = "SELECT * FROM InterviewDetails ID Where ID.UserID=?1 AND RowStatus IN (?2)", nativeQuery = true)
    List<InterviewDetailsEntity> findByUserIdAndRowStatusIn(Long userId, List<Long> rowStatuses);

    @Transactional
    @Modifying
    @Query(value = "UPDATE InterviewDetails ID SET ID.RowStatus=?1, ID.UpdatedAt=now(), ID.UpdatedBy=?2 Where ID.ID IN(?3)", nativeQuery = true)
    int updateInterviewDetailsRowStatus(Long rowStatusId, Long updatedBy, List<Long> interviewDetailsIds);
}
