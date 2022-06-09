package org.educationinusa.university.entity.faq;

import org.educationinusa.university.entity.LookupConfigurationEntity;
import org.educationinusa.university.entity.RowStatusEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Faq")
public class FaqEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Question", nullable = false)
    private String question;

    @Column(name = "Answer", nullable = false)
    private String answer;

    @Column(name = "SourceUrl")
    private String sourceUrl;

    @OneToMany(mappedBy = "faq", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FaqTagEntity> faqTags = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FaqType", nullable = false, referencedColumnName = "ID")
    private LookupConfigurationEntity faqType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VerificationStatus", nullable = false, referencedColumnName = "ID")
    private LookupConfigurationEntity verificationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    public FaqEntity() {
    }

    public FaqEntity(Long id) {
        this.id = id;
    }
    public FaqEntity(Long id, String question, String answer, String sourceUrl, List<FaqTagEntity> faqTags,
                     LookupConfigurationEntity faqType, LookupConfigurationEntity verificationStatus, RowStatusEntity rowStatus) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.sourceUrl = sourceUrl;
        this.faqTags = faqTags;
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

    public List<FaqTagEntity> getFaqTags() {
        return faqTags;
    }

    public void setFaqTags(List<FaqTagEntity> faqTags) {
        this.faqTags = faqTags;
    }

    public LookupConfigurationEntity getFaqType() {
        return faqType;
    }

    public void setFaqType(LookupConfigurationEntity faqType) {
        this.faqType = faqType;
    }

    public LookupConfigurationEntity getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(LookupConfigurationEntity verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }
}
