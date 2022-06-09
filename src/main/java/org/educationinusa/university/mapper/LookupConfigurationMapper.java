package org.educationinusa.university.mapper;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.model.LookupConfiguration;

public class LookupConfigurationMapper {
    public static LookupConfiguration entityToModel(LookupConfigurationEntity entity) {
        LookupConfiguration response = new LookupConfiguration();

        response.setId(entity.getId());
        response.setGroup(entity.getGroup());
        response.setKey(entity.getKey());
        response.setValue(entity.getValue());
        response.setDescription(entity.getDescription());

        return response;
    }
}
