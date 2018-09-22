package org.formation.ajc.family.web;

import java.util.List;

import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.service.FamilyService;
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
	public ResponseEntity<List<Family>> getAllFamily() {

		List<Family> familyList = familyService.findAllFamily();
		
		LOGGER.info("Nomber of families found : {}", familyList.size());
		
		return ResponseEntity.ok(familyList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Family> getFamilyById(@PathVariable("id") Long id) {

		Family family = familyService.findByFamilyId(id);
		
		LOGGER.info("Family found : {}", family.getId());
	
		return ResponseEntity.ok(family);
	}
}
