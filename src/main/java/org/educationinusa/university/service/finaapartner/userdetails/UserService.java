package org.educationinusa.university.service.finaapartner.userdetails;

import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.model.seach.UserLookup;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getProfileById(Long profileId);

    List<User> findUsers(UserLookup userLookup);

    User updateUser(User user, Long userId);
}
