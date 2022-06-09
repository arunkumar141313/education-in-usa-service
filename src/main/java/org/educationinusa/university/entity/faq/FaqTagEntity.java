package org.educationinusa.university.entity.faq;
import org.educationinusa.university.entity.RowStatusEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FaqTags")
public class FaqTagEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "FaqID")
    private FaqEntity faq;

    @ManyToOne()
    @JoinColumn(name = "TagID")
    private TagEntity tag;

    @ManyToOne()
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    public FaqTagEntity() {
    }

    public FaqTagEntity(Long id) {
        this.id = id;
    }

    public FaqTagEntity(Long id, FaqEntity faq, TagEntity tag, RowStatusEntity rowStatus) {
        this.id = id;
        this.faq = faq;
        this.tag = tag;
        this.rowStatus = rowStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FaqEntity getFaq() {
        return faq;
    }

    public void setFaq(FaqEntity faqEntity) {
        this.faq = faqEntity;
    }

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tagEntity) {
        this.tag = tagEntity;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }
}
