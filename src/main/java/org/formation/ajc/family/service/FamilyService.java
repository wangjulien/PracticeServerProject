package org.formation.ajc.family.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.formation.ajc.family.model.Family;
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
		familyToUpdate.getParents().clear();
		familyToUpdate.addParent(familyDetailDto.getFather());
		familyToUpdate.addParent(familyDetailDto.getMother());
		familyToUpdate.setAddress(familyDetailDto.getAddress());
		
		return familyToUpdate;
	}
	
	public Family addNewFamily(final FamilyDetailDto familyDetailDto) {
		Family newFamily = new Family();
		newFamily.addParent(familyDetailDto.getFather());
		newFamily.addParent(familyDetailDto.getMother());
		newFamily.setAddress(familyDetailDto.getAddress());
		newFamily.setChildren(familyDetailDto.getChildren());
		
		return familyRepository.save(newFamily);
	}
	
	public void deleteFamily(final long id) {
		familyRepository.deleteById(id);
	}
}
