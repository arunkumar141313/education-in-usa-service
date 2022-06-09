package org.educationinusa.university.controller.faq;

import org.educationinusa.university.model.faq.Tag;
import org.educationinusa.university.service.faq.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
@RequestMapping(value = {"/tags"})
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping()
    public ResponseEntity<Tag> createTag(@RequestBody() Tag tag) {
        Tag response = tagService.create(tag);
        return new ResponseEntity<>(response, Objects.nonNull(tag) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@RequestBody() Tag tag, @PathVariable("id") Long id) {
        Tag response = tagService.update(tag, id);
        return new ResponseEntity<>(response, Objects.nonNull(tag) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
