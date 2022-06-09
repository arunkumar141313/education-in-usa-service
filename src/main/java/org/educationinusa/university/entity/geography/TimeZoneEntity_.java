package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.RowStatusEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TimeZoneEntity.class)
public class TimeZoneEntity_ {
    public static volatile SingularAttribute<TimeZoneEntity, Long> id;
    public static volatile SingularAttribute<TimeZoneEntity, String> name;
    public static volatile SingularAttribute<TimeZoneEntity, Float> offset;
    public static volatile SingularAttribute<TimeZoneEntity, RowStatusEntity> rowStatus;
    public static volatile ListAttribute<TimeZoneEntity, CountryEntity> countries;
}