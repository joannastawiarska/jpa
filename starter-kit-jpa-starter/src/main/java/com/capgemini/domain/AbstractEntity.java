package com.capgemini.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "INT(10)")
	protected Long id;
	
	@Version
	@Column(columnDefinition="int default '1'")
	private long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	private Timestamp entityDateUpdate;
	private Timestamp entityDateCreate;

	@Column(name = "UPDATE_TS", insertable = false, updatable = true)
	public Timestamp getEntityDateUpdate() {
		return entityDateUpdate;
	}
	
	protected void setEntityDateUpdate(Timestamp entityDateUpdate) {
		this.entityDateUpdate = entityDateUpdate;
	}

	@Column(name = "CREATION_TS", insertable = true, updatable = false)
	public Timestamp getEntityDateCreate() {
		return entityDateCreate;
	}

	protected void setEntityDateCreate(Timestamp entityDateCreate) {
		this.entityDateCreate = entityDateCreate;
	}

	@PrePersist
	 void onCreate() {
		this.setEntityDateCreate(new Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	 void onPersist() {
		this.setEntityDateUpdate(new Timestamp((new Date()).getTime()));
	}
	
	public long getVersion() {
		return version;
	}
	
}
