package org.educationinusa.university.service.impl.V1.geography;

import org.educationinusa.university.entity.geography.StateEntity;
import org.educationinusa.university.mapper.geography.StateMapper;
import org.educationinusa.university.model.geography.State;
import org.educationinusa.university.repository.geography.StateRepository;
import org.educationinusa.university.service.geography.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StateService-V1")
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getAllStatesByCountryId(Long countryId) {
        List<StateEntity> stateEntities = stateRepository.findByCountryId(countryId);
        return StateMapper.listEntityToListModel(stateEntities);
    }
}
