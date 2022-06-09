package org.educationinusa.university.service.geography;

import org.educationinusa.university.model.geography.State;

import java.util.List;

public interface StateService {
    List<State> getAllStatesByCountryId(Long countryId);
}
