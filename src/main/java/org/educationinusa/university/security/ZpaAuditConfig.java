package org.educationinusa.university.security;

import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.service.impl.AuditAwareServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ZpaAuditConfig {
    @Bean
    public AuditorAware<UserEntity> auditorAware() {
        return new AuditAwareServiceImpl();
    }
}