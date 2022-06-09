package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.RowStatusEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CountryEntity.class)
public class CountryEntity_ {
    public static volatile SingularAttribute<CountryEntity, Long> id;
    public static volatile SingularAttribute<CountryEntity, String> name;
    public static volatile SingularAttribute<CountryEntity, String> isoCodeThree;
    public static volatile SingularAttribute<CountryEntity, String> isoCodeTwo;
    public static volatile SingularAttribute<CountryEntity, TimeZoneEntity> timeZone;
    public static volatile SingularAttribute<CountryEntity, RowStatusEntity> rowStatus;
    public static volatile ListAttribute<CountryEntity, StateEntity> states;
}