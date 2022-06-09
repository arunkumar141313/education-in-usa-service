package org.educationinusa.university.controller.finadapartner;

import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.service.finaapartner.userdetails.InterviewDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/interview-details")
public class InterviewDetailsController {

    @Autowired
    private InterviewDetailsService interviewDetailsService;

    @PostMapping("/users/{id}")
    public ResponseEntity<InterviewDetails> addInterviewDetails(
            @PathVariable("id") Long userId,
            @RequestBody() InterviewDetails interviewDetails
    ) {
        InterviewDetails response = interviewDetailsService.addInterviewDetails(userId, interviewDetails);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/users/{userId}")
    public ResponseEntity<InterviewDetails> updateInterviewDetails(
            @PathVariable("id") Long interviewDetailsId,
            @PathVariable("userId") Long userId,
            @RequestBody() InterviewDetails interviewDetails
    ) {
        interviewDetails.setUser(new User(userId));
        InterviewDetails response = interviewDetailsService.updateInterviewDetails(interviewDetailsId, interviewDetails);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<InterviewDetails>> getInterviewDetailsByUserId(
            @PathVariable("id") Long userId,
            @RequestParam(value = "rowStatus", required = false) List<Long> rowStatuses
    ) {
        List<InterviewDetails> response = interviewDetailsService.getByUserIdAndRowStatuses(userId, rowStatuses);
        return new ResponseEntity<>(response, CollectionUtils.isEmpty(response) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInterviewDetails(
            @PathVariable("id") Long interviewDetailsId
    ) {
        Boolean response = interviewDetailsService.deleteInterviewDetails(List.of(interviewDetailsId));
        return new ResponseEntity<>(response, response ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
