package org.formation.ajc.family.web.dto;

import org.formation.ajc.family.model.Child.Section;

public class ActivityDto {
	private Long id;
	private String name;
	private Section sectionAllowed;
	private int freePlaceNum;

	public ActivityDto() {
		super();
	}

	public ActivityDto(Long id, String name, Section sectionAllowed, int freePlaceNum) {
		super();
		this.id = id;
		this.name = name;
		this.sectionAllowed = sectionAllowed;
		this.freePlaceNum = freePlaceNum;
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

	public int getFreePlaceNum() {
		return freePlaceNum;
	}

	public void setFreePlaceNum(int freePlaceNum) {
		this.freePlaceNum = freePlaceNum;
	}
}
