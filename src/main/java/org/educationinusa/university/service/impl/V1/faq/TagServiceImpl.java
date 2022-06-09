package org.educationinusa.university.service.impl.V1.faq;

import org.educationinusa.university.entity.faq.TagEntity;
import org.educationinusa.university.mapper.faq.TagMapper;
import org.educationinusa.university.model.faq.Tag;
import org.educationinusa.university.repository.faq.TagRepository;
import org.educationinusa.university.service.faq.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("TagService-V1")
public class TagServiceImpl implements TagService {

    @Autowired()
    TagRepository tagRepository;

    @Override
    public List<Tag> getAll(Pageable pageable) {
        if (pageable == null) {
            pageable = Pageable.unpaged();
        }
        Page<TagEntity> pagedResult = tagRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return TagMapper.listEntityToListModel(pagedResult.getContent());
        }
        return Collections.emptyList();
    }

    @Override
    public Tag update(Tag tag, Long id) {
        TagEntity tagEntity = TagMapper.modelToEntity(tag);
        tagEntity.setId(id);
        TagEntity savedTagEntity = tagRepository.save(tagEntity);
        return TagMapper.entityToModel(savedTagEntity);
    }
}
