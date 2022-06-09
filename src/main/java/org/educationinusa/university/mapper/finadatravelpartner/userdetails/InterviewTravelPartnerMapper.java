package org.educationinusa.university.mapper.finadatravelpartner.userdetails;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.entity.geography.StateEntity;
import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;

import java.util.ArrayList;
import java.util.List;

public class InterviewTravelPartnerMapper {

    public static InterviewTravelPartnerEntity modelToEntity(InterviewTravelPartner interviewTravelPartner) {
        InterviewTravelPartnerEntity interviewTravelPartnerEntity = new InterviewTravelPartnerEntity();

        interviewTravelPartnerEntity.setId(interviewTravelPartner.getId());
        interviewTravelPartnerEntity.setHasTravelPartner(interviewTravelPartner.getHasTravelPartner());
        interviewTravelPartnerEntity.setTravelDate(interviewTravelPartner.getTravelDate());
        interviewTravelPartnerEntity.setInterviewDetails(new InterviewDetailsEntity(interviewTravelPartner.getInterviewDetails().getId()));
        interviewTravelPartnerEntity.setTravelPartnerRequired(interviewTravelPartner.getTravelPartnerRequired());
        interviewTravelPartnerEntity.setComments(interviewTravelPartner.getComments());
        interviewTravelPartnerEntity.setGenderPreference(new LookupConfigurationEntity(interviewTravelPartner.getGenderPreference()));
        interviewTravelPartnerEntity.setTravelFromCity(interviewTravelPartner.getTravelFromCity());
        interviewTravelPartnerEntity.setRowStatus(new RowStatusEntity(interviewTravelPartner.getRowStatus()));
        interviewTravelPartnerEntity.setTravelFromState(new StateEntity(interviewTravelPartner.getTravelFromState()));
        interviewTravelPartnerEntity.setUser(new UserEntity(interviewTravelPartner.getUser().getId()));

        return interviewTravelPartnerEntity;
    }

    public static InterviewTravelPartner entityToModel(InterviewTravelPartnerEntity interviewTravelPartnerEntity, Boolean mapInterviewDetails, Boolean mapUserDetails) {
        InterviewTravelPartner interviewTravelPartner = entityToModel(interviewTravelPartnerEntity);
        if (mapUserDetails) {
            interviewTravelPartner.setUser(UserMapper.entityToModel(interviewTravelPartnerEntity.getUser()));
        }
        if (mapInterviewDetails) {
            interviewTravelPartner.setInterviewDetails(InterviewDetailsMapper.entityToModel(interviewTravelPartnerEntity.getInterviewDetails()));
        }
        return interviewTravelPartner;
    }

    public static InterviewTravelPartner entityToModel(InterviewTravelPartnerEntity interviewTravelPartnerEntity) {
        InterviewTravelPartner interviewTravelPartner = new InterviewTravelPartner();

        interviewTravelPartner.setId(interviewTravelPartnerEntity.getId());
        interviewTravelPartner.setHasTravelPartner(interviewTravelPartnerEntity.getHasTravelPartner());
        interviewTravelPartner.setTravelDate(interviewTravelPartnerEntity.getTravelDate());
        interviewTravelPartner.setInterviewDetails(new InterviewDetails(interviewTravelPartnerEntity.getInterviewDetails().getId()));
        interviewTravelPartner.setUser(new User(interviewTravelPartnerEntity.getUser().getId()));
        interviewTravelPartner.setTravelPartnerRequired(interviewTravelPartnerEntity.getTravelPartnerRequired());
        interviewTravelPartner.setComments(interviewTravelPartnerEntity.getComments());
        interviewTravelPartner.setGenderPreference(interviewTravelPartnerEntity.getGenderPreference().getId());
        interviewTravelPartner.setTravelFromCity(interviewTravelPartnerEntity.getTravelFromCity());
        interviewTravelPartner.setRowStatus(interviewTravelPartnerEntity.getRowStatus().getId());
        interviewTravelPartner.setTravelFromState(interviewTravelPartnerEntity.getTravelFromState().getId());

        return interviewTravelPartner;
    }

    public static List<InterviewTravelPartnerEntity> listModelToEntity
            (List<InterviewTravelPartner> interviewTravelPartners) {
        List<InterviewTravelPartnerEntity> interviewTravelPartnerEntities = new ArrayList<>();
        interviewTravelPartners.forEach(interviewTravelPartner -> interviewTravelPartnerEntities.add(modelToEntity(interviewTravelPartner)));
        return interviewTravelPartnerEntities;
    }

    public static List<InterviewTravelPartner> listEntityToModel(List<InterviewTravelPartnerEntity> interviewTravelPartnerEntities, Boolean mapInterviewDetails, Boolean mapUserDetails) {
        List<InterviewTravelPartner> interviewTravelPartners = new ArrayList<>();
        interviewTravelPartnerEntities.forEach(interviewTravelPartnerEntity -> interviewTravelPartners.add(entityToModel(interviewTravelPartnerEntity, mapInterviewDetails, mapUserDetails)));
        return interviewTravelPartners;
    }

    public static List<InterviewTravelPartner> listEntityToModel(List<InterviewTravelPartnerEntity> interviewTravelPartnerEntities) {
        List<InterviewTravelPartner> interviewTravelPartners = new ArrayList<>();
        interviewTravelPartnerEntities.forEach(interviewTravelPartnerEntity -> interviewTravelPartners.add(entityToModel(interviewTravelPartnerEntity)));
        return interviewTravelPartners;
    }

    public static void entityToEntity(InterviewTravelPartnerEntity interviewTravelPartnerEntity, InterviewTravelPartner interviewTravelPartner) {
        interviewTravelPartnerEntity.setHasTravelPartner(interviewTravelPartner.getHasTravelPartner());
        interviewTravelPartnerEntity.setTravelDate(interviewTravelPartner.getTravelDate());
        interviewTravelPartnerEntity.setInterviewDetails(new InterviewDetailsEntity(interviewTravelPartner.getInterviewDetails().getId()));
        interviewTravelPartnerEntity.setTravelPartnerRequired(interviewTravelPartner.getTravelPartnerRequired());
        interviewTravelPartnerEntity.setComments(interviewTravelPartner.getComments());
        interviewTravelPartnerEntity.setGenderPreference(new LookupConfigurationEntity(interviewTravelPartner.getGenderPreference()));
        interviewTravelPartnerEntity.setTravelFromCity(interviewTravelPartner.getTravelFromCity());
        interviewTravelPartnerEntity.setRowStatus(new RowStatusEntity(interviewTravelPartner.getRowStatus()));
        interviewTravelPartnerEntity.setTravelFromState(new StateEntity(interviewTravelPartner.getTravelFromState()));
        interviewTravelPartnerEntity.setUser(new UserEntity(interviewTravelPartner.getUser().getId()));
    }
}
