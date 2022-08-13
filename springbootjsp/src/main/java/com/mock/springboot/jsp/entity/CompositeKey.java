package com.mock.springboot.jsp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable {
	@Column(name = "PackgeID")
	private Long PackageID;
	
	@Column(name = "VaccineID")
	private Long VaccineID;

	public CompositeKey() {
		super();
	}

	public CompositeKey(Long packageID, Long vaccineID) {
		super();
		PackageID = packageID;
		VaccineID = vaccineID;
	}

	public Long getPackageID() {
		return PackageID;
	}

	public void setPackageID(Long packageID) {
		PackageID = packageID;
	}

	public Long getVaccineID() {
		return VaccineID;
	}

	public void setVaccineID(Long vaccineID) {
		VaccineID = vaccineID;
	}
}
