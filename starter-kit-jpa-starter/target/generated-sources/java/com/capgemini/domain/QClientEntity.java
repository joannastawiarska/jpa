package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClientEntity is a Querydsl query type for ClientEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientEntity extends EntityPathBase<ClientEntity> {

    private static final long serialVersionUID = 71561476L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClientEntity clientEntity = new QClientEntity("clientEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QAddressEntity address;

    public final StringPath cardNumber = createString("cardNumber");

    public final DateTimePath<java.util.Date> dateBirth = createDateTime("dateBirth", java.util.Date.class);

    public final StringPath email = createString("email");

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateCreate = _super.entityDateCreate;

    //inherited
    public final DateTimePath<java.sql.Timestamp> entityDateUpdate = _super.entityDateUpdate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath surname = createString("surname");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QClientEntity(String variable) {
        this(ClientEntity.class, forVariable(variable), INITS);
    }

    public QClientEntity(Path<? extends ClientEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClientEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClientEntity(PathMetadata metadata, PathInits inits) {
        this(ClientEntity.class, metadata, inits);
    }

    public QClientEntity(Class<? extends ClientEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddressEntity(forProperty("address")) : null;
    }

}

