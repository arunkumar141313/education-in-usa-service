package org.educationinusa.university.repository.geography;

import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmbassyRepository extends PagingAndSortingRepository<EmbassyEntity, Long>, JpaRepository<EmbassyEntity, Long> {
    List<EmbassyEntity> findByCountryId(@NonNull Long id);
}
