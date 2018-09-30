package org.formation.ajc.family.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.formation.ajc.family.model.Child.Section;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "childrenInscribed" })
@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	@Enumerated(EnumType.STRING)
	private Section sectionAllowed;
	private int maxNumChildAllowed;
	
	@ManyToMany(mappedBy = "activities")
	private Set<Child> childrenInscribed = new HashSet<>();

	public Activity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSectionAllowed() {
		return sectionAllowed;
	}

	public void setSectionAllowed(Section sectionAllowed) {
		this.sectionAllowed = sectionAllowed;
	}

	public int getMaxNumChildAllowed() {
		return maxNumChildAllowed;
	}

	public void setMaxNumChildAllowed(int maxNumChildAllowed) {
		this.maxNumChildAllowed = maxNumChildAllowed;
	}

	public Set<Child> getChildrenInscribed() {
		return childrenInscribed;
	}

	public void setChildrenInscribed(Set<Child> childrenInscribed) {
		this.childrenInscribed = childrenInscribed;
	}
	
	public void addChild(Child child) {
		this.childrenInscribed.add(child);
	}
}