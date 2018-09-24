package org.formation.ajc.family.web.dto;

public class FamilyDto {

	private long id;
	private String fatherName;
	private String motherName;
	private int childrenNumber;
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public int getChildrenNumber() {
		return childrenNumber;
	}

	public void setChildrenNumber(int childrenNomber) {
		this.childrenNumber = childrenNomber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
