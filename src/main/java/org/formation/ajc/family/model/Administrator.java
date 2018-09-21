package org.formation.ajc.family.model;

import javax.persistence.Entity;

@Entity
public class Administrator extends User {

	private String employeeNo;
	private String socialSecuNo;

	public Administrator() {
		super();
		addRole(Role.ROLE_ADMIN);
	}

	public Administrator(String employeeNo, String socialSecuNo) {
		super();
		this.employeeNo = employeeNo;
		this.socialSecuNo = socialSecuNo;
		addRole(Role.ROLE_ADMIN);
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getSocialSecuNo() {
		return socialSecuNo;
	}

	public void setSocialSecuNo(String socialSecuNo) {
		this.socialSecuNo = socialSecuNo;
	}
}
