package org.educationinusa.university.service.impl.V1.faq;

import io.micrometer.core.instrument.util.StringUtils;
import org.educationinusa.university.entity.faq.FaqEntity;
import org.educationinusa.university.mapper.faq.FaqMapper;
import org.educationinusa.university.mapper.PaginationMapper;
import org.educationinusa.university.model.PaginatedResponse;
import org.educationinusa.university.model.RowStatus;
import org.educationinusa.university.model.faq.Faq;
import org.educationinusa.university.model.seach.FaqLookup;
import org.educationinusa.university.repository.faq.FaqRepository;
import org.educationinusa.university.service.faq.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service("FaqService-V1")
public class FaqServiceImpl implements FaqService {

    @Autowired
    private FaqRepository faqRepository;

    @Override
    public PaginatedResponse<List<Faq>> getAll(FaqLookup faqLookup, Pageable pageable) {
        Page<FaqEntity> data = null;
        if (Objects.nonNull(faqLookup)) {
            if (StringUtils.isNotBlank(faqLookup.getQuestion())) {
                data = faqRepository.findByQuestion(faqLookup.getQuestion(), pageable);
            } else if (!CollectionUtils.isEmpty(faqLookup.getFaqIds())) {
                data = faqRepository.findByIdIn(faqLookup.getFaqIds(), pageable);
            } else if (!CollectionUtils.isEmpty(faqLookup.getTagIds())) {
                data = faqRepository.findByFaqTags_Tag_IdIn(faqLookup.getTagIds(), pageable);
            }
        } else {
            data = faqRepository.findAll(pageable);
        }
        if (Objects.nonNull(data)) {
            PaginationMapper<List<Faq>> paginatedResponseObj = new PaginationMapper<>();
            PaginatedResponse<List<Faq>> paginatedResponse = paginatedResponseObj.pageToPaginationResponse(data);
            paginatedResponse.setData(FaqMapper.listEntityToListModel(data.getContent()));
            return paginatedResponse;
        }
        return null;
    }

    @Override
    public Faq update(Faq faq, Long id) {
        FaqEntity faqEntity = FaqMapper.modelToEntity(faq);
        faqEntity.setId(id);
        FaqEntity result = faqRepository.saveAndFlush(faqEntity);
        return FaqMapper.entityToModel(result);
    }

    @Override
    public Boolean updateRowStatus(RowStatus rowStatus, List<Long> ids) {
        int count = faqRepository.updateRowStatusById(rowStatus, ids);
        return count > 0 ? Boolean.TRUE : Boolean.FALSE;
    }
}
