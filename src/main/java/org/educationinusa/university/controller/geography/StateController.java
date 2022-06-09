package org.educationinusa.university.controller.geography;

import org.educationinusa.university.model.geography.State;
import org.educationinusa.university.service.geography.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/country/{id}")
    public ResponseEntity<List<State>> getAllStatesByCountry(
            @PathVariable("id") Long countryId
    ) {
        List<State> states = stateService.getAllStatesByCountryId(countryId);
        return new ResponseEntity<>(states, states.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}
