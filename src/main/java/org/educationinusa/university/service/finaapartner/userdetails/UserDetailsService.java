package org.educationinusa.university.service.finaapartner.userdetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
