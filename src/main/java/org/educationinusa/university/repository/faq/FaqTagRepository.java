package org.educationinusa.university.repository.faq;

import org.educationinusa.university.entity.faq.FaqTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqTagRepository extends JpaRepository<FaqTagEntity, Long>, JpaSpecificationExecutor<FaqTagEntity> {
}
