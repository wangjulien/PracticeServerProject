package org.formation.ajc.family.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "family" })
@Entity
public class Child extends Person {

	public static enum Section {
		GRAND, MEDIUM, SMALL;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Section section;

	@ManyToOne
	private Family family;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "children_activites", joinColumns = @JoinColumn(name = "child_id"), inverseJoinColumns = @JoinColumn(name = "activity_id"))
	private Set<Activity> activites = new HashSet<>();

	public Child() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Set<Activity> getActivites() {
		return activites;
	}

	public void setActivites(Set<Activity> activites) {
		this.activites = activites;
	}
	
	public void addActivity(Activity activity) {
		activity.addChild(this);
		this.activites.add(activity);
	}
}
