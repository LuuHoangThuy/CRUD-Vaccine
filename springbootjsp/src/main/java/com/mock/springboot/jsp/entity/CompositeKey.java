package com.mock.springboot.jsp.entity;

import java.io.Serializable;

public class CompositeKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long PackageID;
	
	private Long VaccineID;

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
