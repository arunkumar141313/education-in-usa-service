package org.educationinusa.university.service.finaapartner.userdetails;

import org.educationinusa.university.model.findapartner.profile.User;

public interface AuthService {
    User login(User user);
    User register(User user);
}
