package org.formation.ajc.family.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.model.Parent;
import org.formation.ajc.family.model.Person.Gender;
import org.formation.ajc.family.repository.FamilyRepository;
import org.formation.ajc.family.web.dto.FamilyDetailDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FamilyService {
	
	private final FamilyRepository familyRepository;

	public FamilyService(FamilyRepository familyRepository) {
		super();
		this.familyRepository = familyRepository;
	}

	public Family findByFamilyId(final Long id) {
		Family family = familyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
		family.getChildren().size();

		return family;
	}

	public List<Family> findAllFamily() {
		return familyRepository.findAll();
	}
	
	public Family updateFamily(final FamilyDetailDto familyDetailDto) {
		Family familyToUpdate = familyRepository.findById(familyDetailDto.getId()).orElseThrow(EntityNotFoundException::new);
		
		updateParent(familyDetailDto.getFather(), familyToUpdate.getFather());
		updateParent(familyDetailDto.getMother(), familyToUpdate.getMother());
		familyToUpdate.setAddress(familyDetailDto.getAddress());
		
		return familyToUpdate;
	}
	
	public Family addNewFamily(final FamilyDetailDto familyDetailDto) {
		Family newFamily = new Family();
		familyDetailDto.getFather().setGender(Gender.MALE);
		newFamily.addParent(familyDetailDto.getFather());
		familyDetailDto.getMother().setGender(Gender.FEMALE);
		newFamily.addParent(familyDetailDto.getMother());
		newFamily.setAddress(familyDetailDto.getAddress());
		newFamily.setChildren(familyDetailDto.getChildren());
		
		return familyRepository.save(newFamily);
	}
	
	public void deleteFamily(final long id) {
		familyRepository.deleteById(id);
	}
	
	public Family addChildToFamily(final Long familyId, final Child child) {
		Family familyToUpdate = familyRepository.findById(familyId).orElseThrow(EntityNotFoundException::new);
		familyToUpdate.addChild(child);
		
		return familyToUpdate;
	}
	
	private void updateParent(final Parent parentFrom, final Parent parentTo) {
		parentTo.setFirstName(parentFrom.getFirstName());
		parentTo.setLastName(parentFrom.getLastName());
		parentTo.setAge(parentFrom.getAge());
		parentTo.setTel(parentFrom.getTel());
		parentTo.setEmail(parentFrom.getEmail());		
	}
}
