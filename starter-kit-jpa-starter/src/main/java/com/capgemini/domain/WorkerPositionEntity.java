package com.capgemini.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WORKER_POSITION")
public class WorkerPositionEntity extends AbstractEntity {

	@Column(nullable = false, length = 20)
    private String name;
	
	public WorkerPositionEntity(){
		
	}

	public String getPosition() {
		return name;
	}

	public void setPosition(String position) {
		this.name = position;
	}
	
}
