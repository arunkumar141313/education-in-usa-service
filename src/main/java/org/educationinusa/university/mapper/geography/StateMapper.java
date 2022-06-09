package org.educationinusa.university.mapper.geography;

import org.educationinusa.university.entity.geography.StateEntity;
import org.educationinusa.university.model.geography.State;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StateMapper {
    public static List<State> listEntityToListModel(List<StateEntity> stateEntities) {
        List<State> states = new ArrayList<>();
        if (!CollectionUtils.isEmpty(stateEntities)) {
            stateEntities.forEach(stateEntity -> {
                if (Objects.nonNull(stateEntity))
                    states.add(entityToModel(stateEntity));
            });
        }
        return states;
    }

    public static State entityToModel(StateEntity stateEntity) {
        State state = new State();
        state.setId(stateEntity.getId());
        state.setName(stateEntity.getName());
        state.setRowStatus(stateEntity.getRowStatus().getId());
        return state;
    }
}
