package org.formation.ajc.family.web;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.formation.ajc.family.model.Activity;
import org.formation.ajc.family.repository.ActivityRepository;
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
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
	private ActivityRepository activityRepository;

	@GetMapping
	public ResponseEntity<List<Activity>> getAllActivity() {
		return ResponseEntity.ok(activityRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(activityRepository.findById(id).orElseThrow(EntityNotFoundException::new));
	}

	@PostMapping()
	public ResponseEntity<Activity> addActivity(@Valid @RequestBody final Activity activity) {
		return ResponseEntity.ok(activityRepository.save(activity));

	}

	@PutMapping()
	public ResponseEntity<Activity> updateActivity(@Valid @RequestBody Activity activity) {
		return ResponseEntity.ok(activityRepository.save(activity));
	}

	@DeleteMapping("/{id}")
	public void deleteActivity(@PathVariable(value = "id") Long activityId) {
		activityRepository.deleteById(activityId);
	}

}
