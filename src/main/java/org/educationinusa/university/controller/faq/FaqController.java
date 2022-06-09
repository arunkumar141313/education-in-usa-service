package org.educationinusa.university.controller.faq;

import org.educationinusa.university.model.PaginatedResponse;
import org.educationinusa.university.model.faq.Faq;
import org.educationinusa.university.model.seach.FaqLookup;
import org.educationinusa.university.service.faq.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/faqs")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @GetMapping()
    public ResponseEntity<PaginatedResponse<List<Faq>>> getAllFaqs(
            @RequestBody(required = false) FaqLookup faqLookup,
            Pageable pageable
    ) {
        var faqs = faqService.getAll(faqLookup, pageable);
        return new ResponseEntity<>(faqs, faqs.getSize() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Faq> createFaq(@RequestBody() Faq faq) {
        Faq response = faqService.create(faq);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faq> updateFaq(@RequestBody() Faq faq, @PathVariable("id") Long id) {
        Faq response = faqService.update(faq, id);
        return new ResponseEntity<>(response, Objects.nonNull(response) ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
