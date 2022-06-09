package org.educationinusa.university.service.faq;

import org.educationinusa.university.model.PaginatedResponse;
import org.educationinusa.university.model.RowStatus;
import org.educationinusa.university.model.faq.Faq;
import org.educationinusa.university.model.seach.FaqLookup;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface FaqService {
    PaginatedResponse<List<Faq>> getAll(FaqLookup faqLookup, Pageable pagination);

    default Faq create(Faq faq) {
        return update(faq, null);
    }

    Faq update(Faq faq, Long id);

    Boolean updateRowStatus(RowStatus rowStatus, List<Long> ids);
}
