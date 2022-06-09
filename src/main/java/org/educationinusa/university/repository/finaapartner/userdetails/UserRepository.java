package org.educationinusa.university.repository.finaapartner.userdetails;

import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long>,
        JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByEmailAndPassword(String email, String password);

    List<UserEntity> findAllByPhoneNumberAndPassword(String phoneNumber, String password);

    List<UserEntity> findAllByIdAndPassword(Long id, String password);

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByPhoneNumber(String PhoneNumber);

    Boolean existsByPhoneNumber(String phoneNumber);

    Boolean existsByPhoneNumberAndIdIsNot(String phoneNumber, Long userId);

    Boolean existsByEmailAndIdIsNot(String phoneNumber, Long userId);

}
