package org.educationinusa.university.repository.finaapartner.userdetails;

import org.educationinusa.university.entity.findapartner.profile.RoleEntity;
import org.educationinusa.university.extra.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(RoleEnum name);
}
