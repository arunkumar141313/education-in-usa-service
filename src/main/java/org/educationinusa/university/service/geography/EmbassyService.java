package org.educationinusa.university.service.geography;

import org.educationinusa.university.model.geography.Embassy;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmbassyService {
    List<Embassy> getEmbassiesByCountryId(Long countryId);
}
