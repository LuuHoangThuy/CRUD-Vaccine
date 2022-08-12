package com.mock.springboot.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

@Entity
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "name", columnDefinition = "nvarchar(50)")
	private String name;

	@Column(name = "supplier", columnDefinition = "nvarchar(50)")
	private String supplier;

	@Column(name = "nation", columnDefinition = "nvarchar(50)")
	private String nation;
	
	@Column(name = "sick", columnDefinition = "nvarchar(50)")
	private String sick;

	@Range(min = 0, max = 100000)
	private Long price;

	@Column(name = "note", columnDefinition = "nvarchar(250)")
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Vaccine() {
		super();
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getSick() {
		return sick;
	}

	public void setSick(String sick) {
		this.sick = sick;
	}

}