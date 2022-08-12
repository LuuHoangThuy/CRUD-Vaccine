package com.mock.springboot.jsp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeKey.class)
public class PackageDetails {
	@Id
	private Long PackageID;
	
	@Id
	private Long VaccineID;
}
