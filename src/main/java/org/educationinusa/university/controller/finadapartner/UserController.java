package org.educationinusa.university.controller.finadapartner;

import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.model.seach.UserLookup;
import org.educationinusa.university.service.finaapartner.userdetails.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(
            @RequestBody() final User user
    ) {
        User response = userService.createUser(user);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Long userId,
            @RequestBody() final User user
    ) {
        User response = userService.updateUser(user, userId);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") final Long userId) {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getUsers(@RequestBody() final UserLookup userLookup) {
        List<User> response = userService.findUsers(userLookup);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

}
