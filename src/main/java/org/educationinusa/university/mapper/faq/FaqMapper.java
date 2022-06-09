package org.educationinusa.university.mapper.faq;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.faq.FaqEntity;
import org.educationinusa.university.entity.faq.FaqTagEntity;
import org.educationinusa.university.entity.faq.TagEntity;
import org.educationinusa.university.model.faq.Faq;

import java.util.*;

public class FaqMapper {

    public static List<FaqEntity> modelToListEntity(List<Faq> faqs) {
        if (Objects.nonNull(faqs)) {
            List<FaqEntity> faqEntities = new ArrayList<>();
            faqs.forEach(faq -> faqEntities.add(modelToEntity(faq)));
            return faqEntities;
        }
        return Collections.emptyList();
    }

    public static List<Faq> listEntityToListModel(List<FaqEntity> faqEntities) {
        if (Objects.nonNull(faqEntities)) {
            List<Faq> faqs = new ArrayList<>();
            faqEntities.forEach(faqEntity -> faqs.add(entityToModel(faqEntity)));
            return faqs;
        }
        return Collections.emptyList();
    }

    public static Faq entityToModel(FaqEntity faqEntity) {
        Faq faq = new Faq();

        faq.setId(faqEntity.getId());
        faq.setQuestion(faqEntity.getQuestion());
        faq.setAnswer(faqEntity.getAnswer());
        faq.setSourceUrl(faq.getSourceUrl());
        faq.setRowStatus(faqEntity.getRowStatus().getId());
        faq.setFaqType(faqEntity.getFaqType().getId());
        faq.setVerificationStatus(faqEntity.getVerificationStatus().getId());
        faq.setTags(FaqTagMapper.faqTagEntityListToTagList(faqEntity.getFaqTags()));

        return faq;
    }

    public static FaqEntity modelToEntity(Faq faq) {
        FaqEntity faqEntity = new FaqEntity();

        faqEntity.setId(faq.getId());
        faqEntity.setQuestion(faq.getQuestion());
        faqEntity.setAnswer(faq.getAnswer());
        faqEntity.setSourceUrl(faq.getSourceUrl());

        FaqTagEntity faqTagEntity = new FaqTagEntity();
        faqTagEntity.setFaq(faqEntity);
        faqTagEntity.setTag(new TagEntity(1L));
        faqTagEntity.setRowStatus(new RowStatusEntity(1L));

        faqEntity.getFaqTags().add(faqTagEntity);

        faqEntity.setFaqType(new LookupConfigurationEntity(faq.getFaqType()));
        faqEntity.setVerificationStatus(new LookupConfigurationEntity(faq.getVerificationStatus()));
        faqEntity.setRowStatus(new RowStatusEntity(faq.getRowStatus()));

        return faqEntity;
    }
}
