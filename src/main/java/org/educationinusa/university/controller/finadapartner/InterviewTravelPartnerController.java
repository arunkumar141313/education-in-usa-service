package org.educationinusa.university.controller.finadapartner;

import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;
import org.educationinusa.university.service.finaapartner.userdetails.InterviewTravelPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/interview-travel-partners")
public class InterviewTravelPartnerController {

    @Autowired
    private InterviewTravelPartnerService interviewTravelPartnerService;

    @PostMapping("/users/{user-id}/interview-details/{interview-details-id}")
    public ResponseEntity<InterviewTravelPartner> addInterviewTravelPartner(
            @PathVariable("user-id") Long userId,
            @PathVariable("interview-details-id") Long interviewDetailsId,
            @RequestBody() InterviewTravelPartner interviewTravelPartner
    ) {
        InterviewTravelPartner response = interviewTravelPartnerService.addInterviewTravelPartner(userId, interviewDetailsId, interviewTravelPartner);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("{id}/users/{user-id}/interview-details/{interview-details-id}")
    public ResponseEntity<InterviewTravelPartner> updateInterviewTravelPartner(
            @PathVariable("user-id") Long userId,
            @PathVariable("id") Long interviewTravelPartnerId,
            @PathVariable("interview-details-id") Long interviewDetailsId,
            @RequestBody() InterviewTravelPartner interviewTravelPartner
    ) {
        InterviewTravelPartner response = interviewTravelPartnerService.updateInterviewTravelPartner(userId, interviewDetailsId, interviewTravelPartnerId, interviewTravelPartner);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{interview-travel-partner-id}/users/{user-id}")
    public ResponseEntity<List<InterviewTravelPartner>> findPartnersForInterviewTravel(
            @PathVariable("user-id") Long userId,
            @PathVariable("interview-travel-partner-id") Long interviewTravelPartnerId
    ) {
        List<InterviewTravelPartner> response = interviewTravelPartnerService.findPartnersForInterviewTravel(userId, interviewTravelPartnerId);
        return new ResponseEntity<>(response, CollectionUtils.isEmpty(response) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<List<InterviewTravelPartner>> getAllInterviewTravelPartnerPreferencesByUserId(
            @PathVariable("user-id") Long userId,
            @PathVariable(value = "rowStatus", required = false) List<Long> rowStatus
    ) {
        List<InterviewTravelPartner> response = interviewTravelPartnerService.getAllInterviewTravelPartnerPreferencesByUserId(userId, rowStatus);
        return new ResponseEntity<>(response, CollectionUtils.isEmpty(response) ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PutMapping("/{id}/change-partner-preference")
    public ResponseEntity<Boolean> changePartnerPreference(
            @PathVariable("id") Long interviewTravelPartnerId,
            @RequestParam(value = "hasTravelPartner", required = false) Boolean hasTravelPartner,
            @RequestParam(value = "travelPartnerRequired", required = false) Boolean travelPartnerRequired
    ) {
        Boolean status = interviewTravelPartnerService.changePartnerPreference(interviewTravelPartnerId, hasTravelPartner, travelPartnerRequired);
        return new ResponseEntity<>(status, status ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteInterviewTravelPartner(
            @PathVariable("id") Long interviewTravelPartnerId
    ) {
        Boolean status = interviewTravelPartnerService.deleteInterviewTravelPartner(interviewTravelPartnerId);
        return new ResponseEntity<>(status, status ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
