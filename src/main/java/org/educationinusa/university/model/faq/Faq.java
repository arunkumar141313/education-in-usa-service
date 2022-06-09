package org.educationinusa.university.model.faq;

import java.util.ArrayList;
import java.util.List;

public class Faq {
    private Long id;
    private String question;
    private String answer;
    private String sourceUrl;
    private List<Tag> tags = new ArrayList<>();
    private Long faqType;
    private Long verificationStatus;
    private Long rowStatus;

    public Faq() {
    }

    public Faq(Long id, String question, String answer, String sourceUrl, List<Tag> tags, Long faqType,
               Long verificationStatus, Long rowStatus) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.sourceUrl = sourceUrl;
        this.tags = tags;
        this.faqType = faqType;
        this.verificationStatus = verificationStatus;
        this.rowStatus = rowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getFaqType() {
        return faqType;
    }

    public void setFaqType(Long faqType) {
        this.faqType = faqType;
    }

    public Long getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Long verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }
}
