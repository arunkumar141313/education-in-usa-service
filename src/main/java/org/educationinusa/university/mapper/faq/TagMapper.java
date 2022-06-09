package org.educationinusa.university.mapper.faq;

import org.educationinusa.university.entity.RowStatusEntity;
import org.educationinusa.university.entity.faq.TagEntity;
import org.educationinusa.university.model.RowStatus;
import org.educationinusa.university.model.faq.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagMapper {

    public static List<TagEntity> modelToListEntity(List<Tag> tags) {
        List<TagEntity> tagEntities = new ArrayList<>();
        tags.forEach(tag -> tagEntities.add(modelToEntity(tag)));
        return tagEntities;
    }

    public static List<Tag> listEntityToListModel(List<TagEntity> tagEntities) {
        List<Tag> tags = new ArrayList<>();
        tagEntities.forEach(tagEntity -> tags.add(entityToModel(tagEntity)));
        return tags;
    }

    public static TagEntity modelToEntity(Tag tag) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(tag.getId());
        tagEntity.setName(tag.getName());
        tagEntity.setRowStatus(new RowStatusEntity(tag.getRowStatus()));
        return tagEntity;
    }

    public static Tag entityToModel(TagEntity tagEntity) {
        Tag tag = new Tag();
        tag.setId(tagEntity.getId());
        tag.setName(tagEntity.getName());
        tag.setRowStatus(tagEntity.getRowStatus().getId());
        return tag;
    }
}
