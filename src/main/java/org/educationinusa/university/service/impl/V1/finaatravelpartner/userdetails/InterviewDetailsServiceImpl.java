package org.educationinusa.university.service.impl.V1.finaatravelpartner.userdetails;

import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.mapper.finadatravelpartner.userdetails.InterviewDetailsMapper;
import org.educationinusa.university.model.findapartner.profile.InterviewDetails;
import org.educationinusa.university.model.findapartner.profile.User;
import org.educationinusa.university.repository.finaapartner.userdetails.InterviewDetailsRepository;
import org.educationinusa.university.service.finaapartner.userdetails.InterviewDetailsService;
import org.educationinusa.university.service.impl.AuditAwareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("InterviewDetailsService-V1")
public class InterviewDetailsServiceImpl implements InterviewDetailsService {

    @Autowired
    private InterviewDetailsRepository interviewDetailsRepository;

    @Autowired
    private AuditAwareServiceImpl auditAwareService;

    @Override
    public InterviewDetails addInterviewDetails(Long userid, InterviewDetails interviewDetails) {
        interviewDetails.setUser(new User(userid));
        interviewDetails.setRowStatus(1L);
        InterviewDetailsEntity interviewDetailsEntity = InterviewDetailsMapper.modelToEntity(interviewDetails);
        InterviewDetailsEntity response = interviewDetailsRepository.save(interviewDetailsEntity);
        return InterviewDetailsMapper.entityToModel(response);
    }

    @Override
    public InterviewDetails updateInterviewDetails(Long interviewDetailsId, InterviewDetails interviewDetails) {
        interviewDetails.setRowStatus(1L);
        var interviewDetailsEntity = interviewDetailsRepository.findById(interviewDetailsId);
        if (interviewDetailsEntity.isPresent()) {
            InterviewDetailsEntity entity = interviewDetailsEntity.get();
            InterviewDetailsMapper.entityToEntity(entity, interviewDetails);
            InterviewDetailsEntity response = interviewDetailsRepository.save(entity);
            return InterviewDetailsMapper.entityToModel(response);
        }
        return null;
    }

    @Override
    public List<InterviewDetails> getByUserIdAndRowStatuses(Long userId, List<Long> rowStatuses) {
        List<InterviewDetailsEntity> interviewDetailsEntities;
        if (CollectionUtils.isEmpty(rowStatuses)) {
            interviewDetailsEntities = interviewDetailsRepository.findAllByUserId(userId);
        } else {
            interviewDetailsEntities = interviewDetailsRepository.findByUserIdAndRowStatusIn(userId, rowStatuses);
        }
        return InterviewDetailsMapper.listEntityToModel(interviewDetailsEntities);
    }

    @Override
    public Boolean deleteInterviewDetails(List<Long> interviewDetailsIds) {
        int count = 0;
        var auditor = auditAwareService.getCurrentAuditor();
        if (auditor.isPresent())
            count = interviewDetailsRepository.updateInterviewDetailsRowStatus(3L, auditor.get().getId(), interviewDetailsIds);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}
