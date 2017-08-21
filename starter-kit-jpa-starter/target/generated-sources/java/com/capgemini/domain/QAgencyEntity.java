package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgencyEntity is a Querydsl query type for AgencyEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAgencyEntity extends EntityPathBase<AgencyEntity> {

    private static final long serialVersionUID = 58557886L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAgencyEntity agencyEntity = new QAgencyEntity("agencyEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QAddressEntity address;

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath phoneNumber = createString("phoneNumber");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public final ListPath<WorkerEntity, QWorkerEntity> workers = this.<WorkerEntity, QWorkerEntity>createList("workers", WorkerEntity.class, QWorkerEntity.class, PathInits.DIRECT2);

    public QAgencyEntity(String variable) {
        this(AgencyEntity.class, forVariable(variable), INITS);
    }

    public QAgencyEntity(Path<? extends AgencyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAgencyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAgencyEntity(PathMetadata metadata, PathInits inits) {
        this(AgencyEntity.class, metadata, inits);
    }

    public QAgencyEntity(Class<? extends AgencyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddressEntity(forProperty("address")) : null;
    }

}

