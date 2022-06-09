package org.educationinusa.university.entity.geography;

import org.educationinusa.university.entity.RowStatusEntity;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StateEntity.class)
public class StateEntity_ {
    public static volatile SingularAttribute<StateEntity, Long> id;
    public static volatile SingularAttribute<StateEntity, String> name;
    public static volatile SingularAttribute<StateEntity, CountryEntity> country;
    public static volatile SingularAttribute<StateEntity, RowStatusEntity> rowStatus;
}
