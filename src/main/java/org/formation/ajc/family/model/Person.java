package org.formation.ajc.family.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

	public static enum Gender {
		MALE, FEMALE;
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

	public Gender getGender() {
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
