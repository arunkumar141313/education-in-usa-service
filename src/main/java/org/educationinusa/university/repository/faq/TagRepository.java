package org.educationinusa.university.repository.faq;

import org.educationinusa.university.entity.faq.TagEntity;
import org.educationinusa.university.model.RowStatus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<TagEntity, Long>, JpaSpecificationExecutor<TagRepository> {
    @Modifying()
    @Query(value = "UPDATE Tag SET RowStatus=:rowStatus WHERE ID IN(:ids)", nativeQuery = true)
    int updateRowStatusById(RowStatus rowStatus, List<Long> ids);
}
