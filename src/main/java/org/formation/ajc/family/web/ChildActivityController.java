package org.formation.ajc.family.web;

import java.util.List;

import javax.validation.Valid;

import org.formation.ajc.family.model.Activity;
import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.repository.ChildRepository;
import org.formation.ajc.family.service.ChildActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/children")
public class ChildActivityController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ChildActivityController.class);

	@Autowired
	private ChildActivityService childActivityService;
	
	@Autowired
	private ChildRepository childRepository;

	@GetMapping("/{id}")
	public ResponseEntity<Child> getFamilyById(@PathVariable("id") Long id) {

		Child child = childActivityService.findByChildId(id);

		LOGGER.info("Child found : {}", child.getId());

		return ResponseEntity.ok(child);
	}

	@GetMapping("/{id}/activities")
	public ResponseEntity<List<Activity>> getAllActivitiesAllowableForChild(@PathVariable("id") Long id) {

		List<Activity> activities = childActivityService.getAllActivitiesAllowableForChild(id);

		LOGGER.info("Activities found : {}", activities.size());

		return ResponseEntity.ok(activities);
	}

	@PostMapping("/{id}/activities/{activityId}")
	public void addFamily(@PathVariable("id") Long childId, @PathVariable("activityId") Long activityId) {
		LOGGER.info("Child {} inscribes activity {}", childId, activityId);

		childActivityService.inscribeActivityForChild(childId, activityId);

		LOGGER.info("Activity {} inscribed", activityId);
	}
	
	
	@PutMapping()
	public ResponseEntity<Child> updateActivity(@Valid @RequestBody Child child) {
		return ResponseEntity.ok(childRepository.save(child));
	}
	
	@DeleteMapping("/{id}")
	public void deleteActivity(@PathVariable(value = "id") Long id) {
		childRepository.deleteById(id);
	}
}
