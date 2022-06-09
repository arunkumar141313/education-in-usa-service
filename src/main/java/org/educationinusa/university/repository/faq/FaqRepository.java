package org.educationinusa.university.repository.faq;

import org.educationinusa.university.entity.faq.FaqEntity;
import org.educationinusa.university.model.RowStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends PagingAndSortingRepository<FaqEntity, Long>, JpaRepository<FaqEntity, Long>, JpaSpecificationExecutor<FaqEntity> {

    @Query("from FaqEntity FE WHERE FE.question LIKE %?1%")
    Page<FaqEntity> findByQuestion(String question, Pageable pageable);

    Page<FaqEntity> findByIdIn(List<Long> ids, Pageable pageable);

    Page<FaqEntity> findByFaqTags_Tag_IdIn(List<Long> tagIds, Pageable pageable);

    @Modifying
    @Query(value = "UPDATER Faq SET RowStatus=:rowStatus WHERE ID IN(:ids)", nativeQuery = true)
    int updateRowStatusById(RowStatus rowStatus, List<Long> ids);
}
