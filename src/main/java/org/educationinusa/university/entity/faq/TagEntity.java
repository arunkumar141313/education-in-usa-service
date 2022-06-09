package org.educationinusa.university.entity.faq;

import org.educationinusa.university.entity.RowStatusEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tag")
public class TagEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<FaqTagEntity> faqTags = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "RowStatus", nullable = false, referencedColumnName = "ID")
    private RowStatusEntity rowStatus;

    public TagEntity() {
    }

    public TagEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FaqTagEntity> getFaqTags() {
        return faqTags;
    }

    public void setFaqTags(List<FaqTagEntity> faqTag) {
        this.faqTags = faqTag;
    }

    public RowStatusEntity getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(RowStatusEntity rowStatus) {
        this.rowStatus = rowStatus;
    }
}
