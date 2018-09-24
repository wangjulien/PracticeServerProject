package org.formation.ajc.family.web;

import java.util.ArrayList;
import java.util.List;

import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.model.Person.Gender;
import org.formation.ajc.family.service.FamilyService;
import org.formation.ajc.family.web.dto.FamilyDetailDto;
import org.formation.ajc.family.web.dto.FamilyDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/families")
public class FamilyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FamilyController.class);

	@Autowired
	private FamilyService familyService;

	@GetMapping
	public ResponseEntity<List<FamilyDto>> getAllFamily() {

		List<Family> familyList = familyService.findAllFamily();

		LOGGER.info("Nomber of families found : {}", familyList.size());
		
		// Translate Family Entity to Family Dto object for front View's sake
		List<FamilyDto> familyDtoList = new ArrayList<>();
		for (Family family : familyList) {
			FamilyDto dto = new FamilyDto();
			dto.setId(family.getId());
			dto.setFatherName(family.getParents().stream().filter(p -> Gender.MALE == p.getGender())
					.map(p -> p.getFirstName() + " " + p.getLastName()).findFirst().orElse(""));
			dto.setMotherName(family.getParents().stream().filter(p -> Gender.FEMALE == p.getGender())
					.map(p -> p.getFirstName() + " " + p.getLastName()).findFirst().orElse(""));
			dto.setChildrenNumber(family.getChildren().size());
			dto.setAddress(family.getAddress().toString());
			
			familyDtoList.add(dto);
		}

		return ResponseEntity.ok(familyDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FamilyDetailDto> getFamilyById(@PathVariable("id") Long id) {

		Family family = familyService.findByFamilyId(id);

		LOGGER.info("Family found : {}", family.getId());
		
		FamilyDetailDto dto = new FamilyDetailDto();
		dto.setId(family.getId());
		dto.setFather(family.getParents().stream().filter(p -> Gender.MALE == p.getGender()).findFirst().orElse(null));
		dto.setMother(family.getParents().stream().filter(p -> Gender.FEMALE == p.getGender()).findFirst().orElse(null));
		dto.setChildren(family.getChildren());
		dto.setAddress(family.getAddress());

		return ResponseEntity.ok(dto);
	}
}
