package org.educationinusa.university.mapper.finadatravelpartner.userdetails;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.model.findapartner.profile.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserMapper {

    public static User entityToModel(UserEntity userEntity) {
        if (Objects.nonNull(userEntity)) {
            User user = new User();

            user.setId(userEntity.getId());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setEmail(userEntity.getEmail());
            user.setPhoneNumber(userEntity.getPhoneNumber());
            user.setNickName(userEntity.getNickName());
            if(Objects.nonNull(userEntity.getIntake())) {
                user.setIntake(userEntity.getIntake().getId());
            }
            user.setYear(userEntity.getYear());
            user.setUniversityName(userEntity.getUniversityName());
            user.setMajor(userEntity.getMajor());
            user.setSharePhoneNumber(userEntity.getSharePhoneNumber());
            user.setShareOnlyNickName(userEntity.getShareOnlyNickName());
            user.setRowStatus(userEntity.getRowStatus().getId());
            user.setRoles(userEntity.getUserRoles().stream().filter(userRole -> userRole.getRowStatus().getId().equals(1L)).map(x->x.getRole().getName()).collect(Collectors.toList()));
            return user;
        }
        return null;
    }

    public static UserEntity modelToEntity(User user) {
        if (Objects.nonNull(user)) {
            UserEntity userEntity = new UserEntity();

            userEntity.setId(user.getId());
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
            userEntity.setPassword(user.getPassword());
            userEntity.setSharePhoneNumber(user.getSharePhoneNumber());
            userEntity.setShareOnlyNickName(user.getShareOnlyNickName());
            userEntity.setRowStatus(new RowStatusEntity(user.getRowStatus()));

            return userEntity;
        }
        return null;
    }

    public static List<User> listEntityToModel(List<UserEntity> userEntities) {
        List<User> userList = new ArrayList<>();
        userEntities.forEach(userEntity -> userList.add(entityToModel(userEntity)));
        return userList;
    }

    public static List<UserEntity> listModelToEntity(List<User> userList) {
        List<UserEntity> userEntities = new ArrayList<>();
        userList.forEach(userEntity -> userEntities.add(modelToEntity(userEntity)));
        return userEntities;
    }
}
