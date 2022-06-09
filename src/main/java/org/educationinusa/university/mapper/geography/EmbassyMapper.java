package org.educationinusa.university.mapper.geography;

import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.educationinusa.university.model.geography.Embassy;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmbassyMapper {

    public static List<Embassy> listEntityToListModel(List<EmbassyEntity> embassyEntities) {
        List<Embassy> embassies = new ArrayList<>();
        if (!CollectionUtils.isEmpty(embassyEntities)) {
            embassyEntities.forEach(embassyEntity -> {
                if (Objects.nonNull(embassyEntity)) {
                    embassies.add(entityToModel(embassyEntity));
                }
            });
        }
        return embassies;
    }

    public static Embassy entityToModel(EmbassyEntity embassyEntity) {
        Embassy embassy = new Embassy();
        embassy.setId(embassyEntity.getId());
        embassy.setUrl(embassyEntity.getUrl());
        embassy.setLatitude(embassyEntity.getLatitude());
        embassy.setLongitude(embassyEntity.getLongitude());
        embassy.setAddress(embassyEntity.getAddress());
        embassy.setName(embassyEntity.getName());
        embassy.setDisplayName(embassyEntity.getDisplayName());
        embassy.setIframeUrl(embassyEntity.getIframeUrl());
        embassy.setPhoneNumber(embassyEntity.getPhoneNumber());
        embassy.setWebsite(embassyEntity.getWebsite());
        embassy.setRowStatus(embassyEntity.getRowStatus().getId());
        return embassy;
    }

}
