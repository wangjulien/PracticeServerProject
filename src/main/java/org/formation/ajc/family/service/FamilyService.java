package org.formation.ajc.family.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.repository.FamilyRepository;
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
}
