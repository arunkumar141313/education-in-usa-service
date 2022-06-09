package org.educationinusa.university.repository.geography;

import org.educationinusa.university.entity.geography.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends PagingAndSortingRepository<StateEntity, Long>, JpaRepository<StateEntity, Long> {
    List<StateEntity> findByCountryId(@NonNull Long id);
}
