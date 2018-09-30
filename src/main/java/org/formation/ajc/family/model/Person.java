package org.formation.ajc.family.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

	public static enum Gender {
		MALE("Masculin"), FEMALE("Féminin");

		private String label;

		private Gender(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	private int age;

	public Person() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender.getLabel();
	}

	public Gender getGenderEnum() {
		return gender;
	}

	public void setGender(Gender sex) {
		this.gender = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
