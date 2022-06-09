package org.educationinusa.university.controller;

import org.apache.commons.lang3.BooleanUtils;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.repository.finaapartner.userdetails.UserRepository;
import org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> authenticateUser(@RequestBody User loginRequest) {
        User response = authService.login(loginRequest);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User registerRequest) {
        User response = authService.register(registerRequest);
        var status = HttpStatus.BAD_REQUEST;
        if ((Objects.nonNull(response) && Objects.nonNull(response.getId())
                && BooleanUtils.isNotTrue(response.getEmailAlreadyExists())
                && BooleanUtils.isNotTrue(response.getPhoneNumberAlreadyExists()))) {
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/guest-token")
    public ResponseEntity<User> guestToken() {
        User user = authService.generateGuestToken();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest request, HttpServletResponse response) {
        Boolean status = authService.logout(request, response);
        return new ResponseEntity<>(null, status ? HttpStatus.OK : HttpStatus.BAD_GATEWAY);
    }
}
