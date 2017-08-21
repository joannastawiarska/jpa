package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkerEntity is a Querydsl query type for WorkerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkerEntity extends EntityPathBase<WorkerEntity> {

    private static final long serialVersionUID = 1548451447L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWorkerEntity workerEntity = new QWorkerEntity("workerEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QAddressEntity address;

    public final QAgencyEntity agency;

    public final SetPath<CarEntity, QCarEntity> car = this.<CarEntity, QCarEntity>createSet("car", CarEntity.class, QCarEntity.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> dateBirth = createDateTime("dateBirth", java.util.Date.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final QWorkerPositionEntity position;

    public final StringPath surname = createString("surname");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QWorkerEntity(String variable) {
        this(WorkerEntity.class, forVariable(variable), INITS);
    }

    public QWorkerEntity(Path<? extends WorkerEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWorkerEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWorkerEntity(PathMetadata metadata, PathInits inits) {
        this(WorkerEntity.class, metadata, inits);
    }

    public QWorkerEntity(Class<? extends WorkerEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddressEntity(forProperty("address")) : null;
        this.agency = inits.isInitialized("agency") ? new QAgencyEntity(forProperty("agency"), inits.get("agency")) : null;
        this.position = inits.isInitialized("position") ? new QWorkerPositionEntity(forProperty("position")) : null;
    }

}

