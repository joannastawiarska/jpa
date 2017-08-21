package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddressEntity is a Querydsl query type for AddressEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddressEntity extends EntityPathBase<AddressEntity> {

    private static final long serialVersionUID = -2051448255L;

    public static final QAddressEntity addressEntity = new QAddressEntity("addressEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath city = createString("city");

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath postCode = createString("postCode");

    public final StringPath region = createString("region");

    public final StringPath street = createString("street");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QAddressEntity(String variable) {
        super(AddressEntity.class, forVariable(variable));
    }

    public QAddressEntity(Path<? extends AddressEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddressEntity(PathMetadata metadata) {
        super(AddressEntity.class, metadata);
    }

}

