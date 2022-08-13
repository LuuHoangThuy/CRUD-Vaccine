package com.mock.springboot.jsp.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PackageDetails implements Serializable {
	@EmbeddedId
	private CompositeKey id;

	public PackageDetails() {
		super();
	}

	public PackageDetails(CompositeKey id) {
		super();
		this.id = id;
	}

	public CompositeKey getId() {
		return id;
	}

	public void setId(CompositeKey id) {
		this.id = id;
	}
	
}
