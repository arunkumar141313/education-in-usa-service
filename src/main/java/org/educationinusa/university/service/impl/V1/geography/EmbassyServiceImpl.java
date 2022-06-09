package org.educationinusa.university.service.impl.V1.geography;

import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.educationinusa.university.mapper.geography.EmbassyMapper;
import org.educationinusa.university.model.geography.Embassy;
import org.educationinusa.university.repository.geography.EmbassyRepository;
import org.educationinusa.university.service.geography.EmbassyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmbassyService-V1")
public class EmbassyServiceImpl implements EmbassyService {
    @Autowired
    private EmbassyRepository embassyRepository;

    @Override
    public List<Embassy> getEmbassiesByCountryId(Long countryId) {
        List<EmbassyEntity> embassyEntities = embassyRepository.findByCountryId(countryId);
        return EmbassyMapper.listEntityToListModel(embassyEntities);
    }
}
