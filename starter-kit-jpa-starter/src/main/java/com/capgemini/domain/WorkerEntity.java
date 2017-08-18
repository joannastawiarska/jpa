package com.capgemini.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull

@Entity
@Table(name = "WORKER")
public class WorkerEntity extends AbstractEntity {
	
	//@Enumerated(EnumType.STRING)
	//private WorkerType type;
	@Column(nullable = false, length = 15)
	//@NotNull
    private String name;
	@Column(nullable = false, length = 25)
    private String surname;
	@Column(nullable = false)
    private Date dateBirth;
    @ManyToOne
    private WorkerPositionEntity position;
    @OneToOne
    private AddressEntity address;
    @ManyToOne // wiele pracownikow do jednej placowki
    private AgencyEntity agency;
	
	protected WorkerEntity(){
	}
}
