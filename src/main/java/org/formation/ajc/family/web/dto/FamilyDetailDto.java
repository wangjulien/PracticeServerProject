package org.formation.ajc.family.web.dto;

import java.util.Set;

import org.formation.ajc.family.model.Address;
import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.model.Parent;
	
public class FamilyDetailDto {

	private long id;
	private Parent father;
	private Parent mother;
	private Set<Child> children;
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Parent getFather() {
		return father;
	}

	public void setFather(Parent father) {
		this.father = father;
	}

	public Parent getMother() {
		return mother;
	}

	public void setMother(Parent mother) {
		this.mother = mother;
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
