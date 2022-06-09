package org.educationinusa.university.service.faq;

import org.educationinusa.university.model.RowStatus;
import org.educationinusa.university.model.faq.Tag;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    List<Tag> getAll(Pageable pageable);

    default Tag create(Tag tag) {
        return update(tag, null);
    }

    Tag update(Tag tag, Long id);
}

