package org.educationinusa.university.model.seach;

import java.util.List;

public class FaqLookup {
    private Long faqType;
    private String question;
    private List<Long> faqIds;
    private List<Long> tagIds;

    public FaqLookup() {
    }

    public FaqLookup(Long faqType, String question, List<Long> faqIds, List<Long> tagIds) {
        this.faqType = faqType;
        this.question = question;
        this.faqIds = faqIds;
        this.tagIds = tagIds;
    }

    public Long getFaqType() {
        return faqType;
    }

    public void setFaqType(Long faqType) {
        this.faqType = faqType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Long> getFaqIds() {
        return faqIds;
    }

    public void setFaqIds(List<Long> faqIds) {
        this.faqIds = faqIds;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
