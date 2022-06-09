package org.educationinusa.university.mapper.faq;

import org.educationinusa.university.entity.faq.FaqTagEntity;
import org.educationinusa.university.model.faq.Tag;

import java.util.ArrayList;
import java.util.List;

public class FaqTagMapper {

    public static List<Tag> faqTagEntityListToTagList(List<FaqTagEntity> faqTagEntities) {
        List<Tag> tags = new ArrayList<>();
        faqTagEntities.forEach(faqTagEntity -> tags.add(faqTagEntityToTagModel(faqTagEntity)));
        return tags;
    }

    public static Tag faqTagEntityToTagModel(FaqTagEntity faqTagEntity) {
        Tag tag = new Tag();
        tag.setId(faqTagEntity.getTag().getId());
        tag.setName(faqTagEntity.getTag().getName());
        tag.setRowStatus(faqTagEntity.getRowStatus().getId());
        return tag;
    }

}