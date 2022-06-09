package org.educationinusa.university.model.faq;

public class FaqTag {
    private Long id;
    private Faq faq;
    private Tag tag;
    private Long rowStatus;

    public FaqTag() {
    }

    public FaqTag(Long id, Faq faq, Tag tag, Long rowStatus) {
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

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Long getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Long rowStatus) {
        this.rowStatus = rowStatus;
    }

}
