package org.educationinusa.university.mapper.finadatravelpartner.userdetails;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InterviewDetailsMapper {
    public static InterviewDetails entityToModel(InterviewDetailsEntity interviewDetailsEntity) {
        if (Objects.nonNull(interviewDetailsEntity)) {

            InterviewDetails interviewDetails = new InterviewDetails();
            interviewDetails.setId(interviewDetailsEntity.getId());
            interviewDetails.setInterviewDate(interviewDetailsEntity.getInterviewDate());
            interviewDetails.setInterviewStatus(interviewDetailsEntity.getInterviewStatus().getId());
            interviewDetails.setInterviewType(interviewDetailsEntity.getInterviewType().getId());
            interviewDetails.setRowStatus(interviewDetailsEntity.getRowStatus().getId());
            interviewDetails.setComments(interviewDetailsEntity.getComments());
            interviewDetails.setEmbassy(interviewDetailsEntity.getEmbassy().getId());
            interviewDetails.setUser(new User(interviewDetailsEntity.getUser().getId()));

            return interviewDetails;
        }
        return null;
    }

    public static InterviewDetailsEntity entityToEntity(InterviewDetailsEntity interviewDetailsEntity, InterviewDetails requestModel) {
        interviewDetailsEntity.setInterviewDate(requestModel.getInterviewDate());
        interviewDetailsEntity.setInterviewStatus(new LookupConfigurationEntity(requestModel.getInterviewStatus()));
        interviewDetailsEntity.setInterviewType(new LookupConfigurationEntity(requestModel.getInterviewType()));
        interviewDetailsEntity.setRowStatus(new RowStatusEntity(requestModel.getRowStatus()));
        interviewDetailsEntity.setComments(requestModel.getComments());
        interviewDetailsEntity.setEmbassy(new EmbassyEntity(requestModel.getEmbassy()));
        interviewDetailsEntity.setUser(new UserEntity(requestModel.getUser().getId()));
        return interviewDetailsEntity;
    }

    public static InterviewDetailsEntity modelToEntity(InterviewDetails interviewDetails) {
        InterviewDetailsEntity interviewDetailsEntity = new InterviewDetailsEntity();
        interviewDetailsEntity.setId(interviewDetails.getId());
        interviewDetailsEntity.setInterviewDate(interviewDetails.getInterviewDate());
        interviewDetailsEntity.setInterviewStatus(new LookupConfigurationEntity(interviewDetails.getInterviewStatus()));
        interviewDetailsEntity.setInterviewType(new LookupConfigurationEntity(interviewDetails.getInterviewType()));
        interviewDetailsEntity.setRowStatus(new RowStatusEntity(interviewDetails.getRowStatus()));
        interviewDetailsEntity.setComments(interviewDetails.getComments());
        interviewDetailsEntity.setEmbassy(new EmbassyEntity(interviewDetails.getEmbassy()));
        interviewDetailsEntity.setUser(new UserEntity(interviewDetails.getUser().getId()));

        return interviewDetailsEntity;
    }

    public List<InterviewDetailsEntity> listModelToEntity(List<InterviewDetails> interviewDetails) {
        List<InterviewDetailsEntity> interviewDetailsEntityList = new ArrayList<>();
        interviewDetails.forEach(interviewDetails1 -> interviewDetailsEntityList.add(modelToEntity(interviewDetails1)));
        return interviewDetailsEntityList;
    }

    public static List<InterviewDetails> listEntityToModel(List<InterviewDetailsEntity> interviewDetailsEntityList) {
        List<InterviewDetails> interviewDetails = new ArrayList<>();
        interviewDetailsEntityList.forEach(interviewDetailsEntity -> interviewDetails.add(entityToModel(interviewDetailsEntity)));
        return interviewDetails;
    }
}
