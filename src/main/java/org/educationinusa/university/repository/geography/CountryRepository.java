package org.educationinusa.university.repository.geography;

import org.educationinusa.university.entity.geography.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<CountryEntity, Long>, JpaRepository<CountryEntity, Long> {
}
