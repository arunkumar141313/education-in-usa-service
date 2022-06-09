package org.educationinusa.university.service.impl;

import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails.UserDetailsImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Service("AuditAwareService")
public class AuditAwareServiceImpl implements AuditorAware<UserEntity> {
    @Override
    public Optional<UserEntity> getCurrentAuditor() {
       var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (nonNull(authentication)&& !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
            if (nonNull(user) && nonNull(user.getId())) {
                return Optional.of(new UserEntity(user.getId()));
            }
        }
        return Optional.of(new UserEntity(1L));
    }
}