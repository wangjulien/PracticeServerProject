package org.formation.ajc.family.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.formation.ajc.family.model.Person.Gender;

@Entity
public class Family {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
	private Set<Parent> parents = new HashSet<>();

	@OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
	private Set<Child> children = new HashSet<>();

	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Parent> getParents() {
		return parents;
	}

	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
	
	public void addParent(Parent parent) {
		parent.setFamily(this);
		this.parents.add(parent);
	}

	public Set<Child> getChildren() {
		return children;
	}

	public void setChildren(Set<Child> children) {
		this.children = children;
	}

	public void addChild(Child child) {
		child.setFamily(this);
		this.children.add(child);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Parent getFather() {
		return parents.stream().filter(p -> Gender.MALE == p.getGenderEnum()).findFirst().orElse(null);
	}
	
	public Parent getMother() {
		return parents.stream().filter(p -> Gender.FEMALE == p.getGenderEnum()).findFirst().orElse(null);
	}
}
