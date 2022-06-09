package org.educationinusa.university.controller.geography;

import org.educationinusa.university.model.geography.Embassy;
import org.educationinusa.university.service.geography.EmbassyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("embassies")
public class EmbassyController {

    @Autowired
    private EmbassyService embassyService;

    @GetMapping("/country/{id}")
    public ResponseEntity<List<Embassy>> getAllEmbassiesByCountry(
            @PathVariable("id") Long countryId
    ) {
        List<Embassy> embassies = embassyService.getEmbassiesByCountryId(countryId);
        return new ResponseEntity<>(embassies, embassies.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

}
