package org.educationinusa.university.entity;

import org.educationinusa.university.entity.faq.FaqEntity;
import org.educationinusa.university.entity.faq.FaqTagEntity;
import org.educationinusa.university.entity.faq.TagEntity;
import org.educationinusa.university.entity.findapartner.profile.InterviewDetailsEntity;
import org.educationinusa.university.entity.findapartner.profile.UserEntity;
import org.educationinusa.university.entity.findapartner.interviewtravelpartner.InterviewTravelPartnerEntity;
import org.educationinusa.university.entity.geography.CountryEntity;
import org.educationinusa.university.entity.geography.EmbassyEntity;
import org.educationinusa.university.entity.geography.StateEntity;
import org.educationinusa.university.entity.geography.TimeZoneEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "RowStatus")
public class RowStatusEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<FaqEntity> faqs;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<TagEntity> tags;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<FaqTagEntity> faqTags;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<LookupConfigurationEntity> lookupConfigurations;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<CountryEntity> countries;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<StateEntity> states;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<TimeZoneEntity> timeZones;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<EmbassyEntity> embassies;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<InterviewDetailsEntity> interviewDetails;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<UserEntity> users;

    @OneToMany(mappedBy = "rowStatus", fetch = FetchType.LAZY)
    private List<InterviewTravelPartnerEntity> interviewTravelPartners;

    public RowStatusEntity() {
    }

    public RowStatusEntity(Long id) {
        this.id = id;
    }

    public RowStatusEntity(Long id, String name, List<FaqEntity> faqs, List<TagEntity> tags, List<FaqTagEntity> faqTags,
                           List<LookupConfigurationEntity> lookupConfigurations) {
        this.id = id;
        this.name = name;
        this.faqs = faqs;
        this.tags = tags;
        this.faqTags = faqTags;
        this.lookupConfigurations = lookupConfigurations;
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

    public List<FaqEntity> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<FaqEntity> faqs) {
        this.faqs = faqs;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public List<FaqTagEntity> getFaqTags() {
        return faqTags;
    }

    public void setFaqTags(List<FaqTagEntity> faqTags) {
        this.faqTags = faqTags;
    }

    public List<LookupConfigurationEntity> getLookupConfigurations() {
        return lookupConfigurations;
    }

    public void setLookupConfigurations(List<LookupConfigurationEntity> lookupConfigurations) {
        this.lookupConfigurations = lookupConfigurations;
    }
}
