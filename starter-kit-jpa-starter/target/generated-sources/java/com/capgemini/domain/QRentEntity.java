package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRentEntity is a Querydsl query type for RentEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRentEntity extends EntityPathBase<RentEntity> {

    private static final long serialVersionUID = 564425586L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRentEntity rentEntity = new QRentEntity("rentEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QAgencyEntity agencyFrom;

    public final QAgencyEntity agencyTo;

    public final QCarEntity car;

    public final QClientEntity client;

    public final NumberPath<Float> cost = createNumber("cost", Float.class);

    public final DateTimePath<java.util.Date> dateRent = createDateTime("dateRent", java.util.Date.class);

    public final DatePath<java.util.Date> dateReturn = createDate("dateReturn", java.util.Date.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QRentEntity(String variable) {
        this(RentEntity.class, forVariable(variable), INITS);
    }

    public QRentEntity(Path<? extends RentEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRentEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRentEntity(PathMetadata metadata, PathInits inits) {
        this(RentEntity.class, metadata, inits);
    }

    public QRentEntity(Class<? extends RentEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.agencyFrom = inits.isInitialized("agencyFrom") ? new QAgencyEntity(forProperty("agencyFrom"), inits.get("agencyFrom")) : null;
        this.agencyTo = inits.isInitialized("agencyTo") ? new QAgencyEntity(forProperty("agencyTo"), inits.get("agencyTo")) : null;
        this.car = inits.isInitialized("car") ? new QCarEntity(forProperty("car")) : null;
        this.client = inits.isInitialized("client") ? new QClientEntity(forProperty("client"), inits.get("client")) : null;
    }

}

