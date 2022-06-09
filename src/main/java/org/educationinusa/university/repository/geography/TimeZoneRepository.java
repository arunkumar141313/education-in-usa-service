package org.educationinusa.university.repository.geography;

import org.educationinusa.university.entity.geography.TimeZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeZoneRepository extends PagingAndSortingRepository<TimeZoneEntity, Long>, JpaRepository<TimeZoneEntity, Long> {
}
