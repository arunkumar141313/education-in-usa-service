package org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails;

import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.educationinusa.university.extra.enums.Constants;
import org.educationinusa.university.mapper.finadatravelpartner.userdetails.InterviewTravelPartnerMapper;
import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.model.findapartner.visainterviewtravel.InterviewTravelPartner;
import org.educationinusa.university.repository.finaapartner.userdetails.InterviewTravelPartnerRepository;
import org.educationinusa.university.service.finaapartner.userdetails.InterviewTravelPartnerService;
import org.educationinusa.university.service.impl.AuditAwareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.*;

@Service("InterviewTravelPartnerService-V1")
public class InterviewTravelPartnerServiceImpl implements InterviewTravelPartnerService {

    @Autowired
    private InterviewTravelPartnerRepository interviewTravelPartnerRepository;

    @Autowired
    private AuditAwareServiceImpl auditAwareService;

    @Override
    public InterviewTravelPartner addInterviewTravelPartner(Long userId, Long interviewDetailsId, InterviewTravelPartner interviewTravelPartner) {
        interviewTravelPartner.setUser(new User(userId));
        interviewTravelPartner.setInterviewDetails(new InterviewDetails(interviewDetailsId));
        interviewTravelPartner.setRowStatus(1L);
        InterviewTravelPartnerEntity interviewTravelPartnerEntity = InterviewTravelPartnerMapper.modelToEntity(interviewTravelPartner);
        InterviewTravelPartnerEntity response = interviewTravelPartnerRepository.save(interviewTravelPartnerEntity);
        return InterviewTravelPartnerMapper.entityToModel(response);
    }

    @Override
    public List<InterviewTravelPartner> getAllInterviewTravelPartnerPreferencesByUserId(Long userId, List<Long> rowStatuses) {
        if (CollectionUtils.isEmpty(rowStatuses)) {
            rowStatuses = List.of(1L);
        }
        List<InterviewTravelPartnerEntity> interviewTravelPartners = interviewTravelPartnerRepository.findAllByUserId(userId, rowStatuses);
        return InterviewTravelPartnerMapper.listEntityToModel(interviewTravelPartners);
    }

    @Override
    public List<InterviewTravelPartner> findPartnersForInterviewTravel(Long userId, Long interviewTravelPartnerId) {
        Optional<InterviewTravelPartnerEntity> interviewTravelPartner = interviewTravelPartnerRepository.findById(interviewTravelPartnerId);
        if (interviewTravelPartner.isPresent()) {
            var genderPreferenceId = interviewTravelPartner.get().getGenderPreference().getId();
            List<Long> genderPreferences = new ArrayList<>(Collections.emptyList());
            genderPreferences.add(Constants.LookupConfigurationConstant.GenderPreference.BOTH);
            if (Objects.equals(genderPreferenceId, Constants.LookupConfigurationConstant.GenderPreference.BOTH)) {
                genderPreferences.add(Constants.LookupConfigurationConstant.GenderPreference.MALE);
                genderPreferences.add(Constants.LookupConfigurationConstant.GenderPreference.FEMALE);
            } else if (Objects.equals(genderPreferenceId, Constants.LookupConfigurationConstant.GenderPreference.MALE)) {
                genderPreferences.add(Constants.LookupConfigurationConstant.GenderPreference.MALE);
            } else if (Objects.equals(genderPreferenceId, Constants.LookupConfigurationConstant.GenderPreference.FEMALE)) {
                genderPreferences.add(Constants.LookupConfigurationConstant.GenderPreference.FEMALE);
            }
            var travelFromStateId = interviewTravelPartner.get().getTravelFromState().getId();
            Instant interviewDate = interviewTravelPartner.get().getInterviewDetails().getInterviewDate();
//            Instant min = interviewDate.truncatedTo(ChronoUnit.DAYS);
//            Instant max = min.plus(1, ChronoUnit.DAYS);
            List<InterviewTravelPartnerEntity> matchesList = interviewTravelPartnerRepository.findPartnersForInterviewTravel(genderPreferences, userId, travelFromStateId, interviewDate);
            return InterviewTravelPartnerMapper.listEntityToModel(matchesList, Boolean.TRUE, Boolean.TRUE);
        }
        return null;
    }

    @Override
    public Boolean changePartnerPreference(Long interviewTravelPartnerId, Boolean hasTravelPartner, Boolean travelPartnerRequired) {
        int count = 0;
        var auditor = auditAwareService.getCurrentAuditor();
        if (auditor.isPresent()) {
            if (Objects.nonNull(hasTravelPartner)) {
                count = interviewTravelPartnerRepository.updateHasTravelPartnerPreference(hasTravelPartner, auditor.get().getId(), interviewTravelPartnerId);
            }
            if (Objects.nonNull(travelPartnerRequired)) {
                count = interviewTravelPartnerRepository.updateTravelPartnerRequiredPreference(travelPartnerRequired, auditor.get().getId(), interviewTravelPartnerId);
            }
        }
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean deleteInterviewTravelPartner(Long interviewTravelPartnerId) {
        int count = 0;
        var auditor = auditAwareService.getCurrentAuditor();
        if (auditor.isPresent()) {
            count = interviewTravelPartnerRepository.deleteInterviewTravelPartner(auditor.get().getId(), interviewTravelPartnerId);
        }
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public InterviewTravelPartner updateInterviewTravelPartner(Long userId, Long interviewDetailsId, Long interviewTravelPartnerId, InterviewTravelPartner interviewTravelPartner) {
        interviewTravelPartner.setUser(new User(userId));
        interviewTravelPartner.setInterviewDetails(new InterviewDetails(interviewDetailsId));
        interviewTravelPartner.setRowStatus(1L);
        interviewTravelPartner.setId(interviewTravelPartnerId);
        var dbResponseEntity = interviewTravelPartnerRepository.findById(interviewDetailsId);
        if (dbResponseEntity.isPresent()) {
            InterviewTravelPartnerMapper.entityToEntity(dbResponseEntity.get(), interviewTravelPartner);
            InterviewTravelPartnerEntity response = interviewTravelPartnerRepository.save(dbResponseEntity.get());
            return InterviewTravelPartnerMapper.entityToModel(response);
        }
        return null;
    }

}
