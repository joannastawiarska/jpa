package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkerPositionEntity is a Querydsl query type for WorkerPositionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkerPositionEntity extends EntityPathBase<WorkerPositionEntity> {

    private static final long serialVersionUID = 341961984L;

    public static final QWorkerPositionEntity workerPositionEntity = new QWorkerPositionEntity("workerPositionEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QWorkerPositionEntity(String variable) {
        super(WorkerPositionEntity.class, forVariable(variable));
    }

    public QWorkerPositionEntity(Path<? extends WorkerPositionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkerPositionEntity(PathMetadata metadata) {
        super(WorkerPositionEntity.class, metadata);
    }

}

