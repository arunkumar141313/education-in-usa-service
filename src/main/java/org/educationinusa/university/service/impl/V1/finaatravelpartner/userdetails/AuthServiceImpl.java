package org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails;

import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.profile.RoleEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.entity.findapartner.profile.UserRoleEntity;
import org.educationinusa.university.extra.enums.Constants;
import org.educationinusa.university.extra.enums.RoleEnum;
import org.educationinusa.university.mapper.finadatravelpartner.userdetails.UserMapper;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.repository.finaapartner.userdetails.RoleRepository;
import org.educationinusa.university.repository.finaapartner.userdetails.UserRepository;
import org.educationinusa.university.security.jwt.JwtUtils;
import org.educationinusa.university.service.finaapartner.userdetails.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public User login(User user) {
        Authentication authentication = getAuthentication(user.getEmail(), user.getPassword());
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = getJwtToken(authentication);
        UserEntity userEntity = userRepository.findById(userDetails.getId()).orElse(null);
        User response = UserMapper.entityToModel(userEntity);
        if (response != null) {
            jwtUtils.cachePutJwtToken(jwt, user.getEmail());
            response.setJwt(jwt);
        }
        return response;
    }

    final Authentication getAuthentication(String email, String password) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }

    final String getJwtToken(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }

    @Override
    public User register(User user) {

        // validating duplicate phone number
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            user.setPhoneNumberAlreadyExists(Boolean.TRUE);
            return user;
        }

        // validating duplicate email
        if (userRepository.existsByEmail(user.getEmail())) {
            user.setEmailAlreadyExists(Boolean.TRUE);
            return user;
        }

        // setting user status to ACTIVE
        user.setRowStatus(1L);

        // Create new user's account
        UserEntity userEntity = UserMapper.modelToEntity(user);
        if (nonNull(userEntity)) {
            // encoding password
            userEntity.setPassword(encoder.encode(user.getPassword()));

            // Assigning Active USER Role
            RoleEntity userRole = roleRepository.findByName(RoleEnum.USER).orElse(null);
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRole(userRole);
            userRoleEntity.setRowStatus(new RowStatusEntity(1L));
            userRoleEntity.setUser(userEntity);
            List<UserRoleEntity> userRoleEntities = new ArrayList<>();
            userRoleEntities.add(userRoleEntity);
            userEntity.setUserRoles(userRoleEntities);

            // creating user
            UserEntity dbResponse = userRepository.save(userEntity);

            // mapping JWT to user
            Authentication authentication = getAuthentication(user.getEmail(), user.getPassword());
            User response = UserMapper.entityToModel(dbResponse);
            if (nonNull(response)) {
                var jwt = getJwtToken(authentication);
                jwtUtils.cachePutJwtToken(jwt, user.getEmail());
                response.setJwt(jwt);
            }
            return response;
        } else {
            return null;
        }
    }

    public User generateGuestToken() {
        Authentication authentication = getAuthentication(Constants.UserDetails.GUEST_MAIL, Constants.UserDetails.GUEST_PASS);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String jwt = getJwtToken(authentication);
        UserEntity userEntity = userRepository.findById(userDetails.getId()).orElse(null);
        User response = UserMapper.entityToModel(userEntity);
        if (response != null) {
            response.setJwt(jwt);
        }
        return response;
    }

    public Boolean logout(HttpServletRequest request, HttpServletResponse response) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (nonNull(authentication) && !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();
            if (nonNull(user) && nonNull(user.getId())) {
                if (!user.getEmail().equals(Constants.UserDetails.GUEST_MAIL)) {
                    jwtUtils.removeCachedJwtToken(user.getEmail());
                }
            }
        }
        return Boolean.TRUE;
    }
}
