package org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails;

import org.apache.commons.lang3.StringUtils;
import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.mapper.finadatravelpartner.userdetails.UserMapper;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.model.seach.UserLookup;
import org.educationinusa.university.repository.finaapartner.userdetails.UserRepository;
import org.educationinusa.university.service.finaapartner.userdetails.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("UserService-V1")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public User createUser(User user) {
        UserEntity request = UserMapper.modelToEntity(user);
        UserEntity response = null;
        if(Objects.nonNull(request)) {
            response = userRepository.save(request);
        }
        return UserMapper.entityToModel(response);
    }

    @Override
    public User getProfileById(Long profileId) {
        UserEntity response = userRepository.findById(profileId).orElse(null);
        return UserMapper.entityToModel(response);
    }

    @Override
    public List<User> findUsers(UserLookup userLookup) {
        if (Objects.nonNull(userLookup) && StringUtils.isNotBlank(userLookup.getPassword())) {
            List<UserEntity> response = null;
            if (StringUtils.isNotBlank(userLookup.getEmail())) {
                response = userRepository.findAllByEmailAndPassword(userLookup.getEmail(), userLookup.getPassword());
            } else if (StringUtils.isNotBlank(userLookup.getPhoneNumber())) {
                response = userRepository.findAllByPhoneNumberAndPassword(userLookup.getPhoneNumber(), userLookup.getPassword());
            } else if (Objects.nonNull(userLookup.getId())) {
                response = userRepository.findAllByIdAndPassword(userLookup.getId(), userLookup.getPassword());
            }
            return UserMapper.listEntityToModel(response);
        }
        return null;
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<UserEntity> accountExists = userRepository.findById(userId);
        if (accountExists.isPresent()) {
            if (userRepository.existsByPhoneNumberAndIdIsNot(user.getPhoneNumber(), userId)) {
                user.setPhoneNumberAlreadyExists(Boolean.TRUE);
                return user;
            }
            if (userRepository.existsByEmailAndIdIsNot(user.getEmail(), userId)) {
                user.setEmailAlreadyExists(Boolean.TRUE);
                return user;
            }
            user.setId(userId);
            UserEntity userEntity = accountExists.get();
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setPhoneNumber(user.getPhoneNumber());
            userEntity.setNickName(user.getNickName());
            if (Objects.nonNull(user.getIntake())) {
                userEntity.setIntake(new LookupConfigurationEntity(user.getIntake()));
            }
            userEntity.setYear(user.getYear());
            userEntity.setUniversityName(user.getUniversityName());
            userEntity.setMajor(user.getMajor());
            if (StringUtils.isNotBlank(user.getPassword())) {
                userEntity.setPassword(encoder.encode(user.getPassword()));
            }
            userEntity.setSharePhoneNumber(user.getSharePhoneNumber());
            userEntity.setShareOnlyNickName(user.getShareOnlyNickName());
            userEntity.setRowStatus(new RowStatusEntity(1L));
            UserEntity response = userRepository.save(userEntity);

            return UserMapper.entityToModel(response);
        }
        return null;
    }
}
