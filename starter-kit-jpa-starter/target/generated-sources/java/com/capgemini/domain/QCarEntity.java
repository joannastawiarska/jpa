package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarEntity is a Querydsl query type for CarEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCarEntity extends EntityPathBase<CarEntity> {

    private static final long serialVersionUID = -1290333407L;

    public static final QCarEntity carEntity = new QCarEntity("carEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final StringPath color = createString("color");

    public final NumberPath<Double> engine = createNumber("engine", Double.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath make = createString("make");

    public final NumberPath<Double> mileage = createNumber("mileage", Double.class);

    public final NumberPath<Integer> power = createNumber("power", Integer.class);

    public final NumberPath<Integer> productionYear = createNumber("productionYear", Integer.class);

    public final SetPath<RentEntity, QRentEntity> rents = this.<RentEntity, QRentEntity>createSet("rents", RentEntity.class, QRentEntity.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public final SetPath<WorkerEntity, QWorkerEntity> worker = this.<WorkerEntity, QWorkerEntity>createSet("worker", WorkerEntity.class, QWorkerEntity.class, PathInits.DIRECT2);

    public QCarEntity(String variable) {
        super(CarEntity.class, forVariable(variable));
    }

    public QCarEntity(Path<? extends CarEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarEntity(PathMetadata metadata) {
        super(CarEntity.class, metadata);
    }

}

