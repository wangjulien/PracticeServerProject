package org.formation.ajc.family.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.formation.ajc.family.model.Activity;
import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.repository.ActivityRepository;
import org.formation.ajc.family.repository.ChildRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChildActivityService {

	private final ChildRepository childRepository;
	private final ActivityRepository activityRepository;

	public ChildActivityService(ChildRepository childRepository, ActivityRepository activityRepository) {
		super();
		this.childRepository = childRepository;
		this.activityRepository = activityRepository;
	}

	public Child findByChildId(final Long id) {
		return childRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public List<Activity> getAllActivitiesAllowableForChild(final Long childId) {
		Child child = childRepository.findById(childId).orElseThrow(EntityNotFoundException::new);

		List<Activity> allowed = activityRepository.findAll().stream().filter(a -> this.checkIfAllowable(child, a))
				.collect(Collectors.toList());

		return allowed;
	}

	public void inscribeActivityForChild(final Long childId, final Long activityId) {
		Child child = childRepository.findById(childId).orElseThrow(EntityNotFoundException::new);
		Activity activity = activityRepository.findById(activityId).orElseThrow(EntityNotFoundException::new);

		if (checkIfAllowable(child, activity)) {
			child.addActivity(activity);
		} else
			throw new RuntimeException("Activity is not allowable for child");
	}

	// Business logic
	private boolean checkIfAllowable(final Child child, final Activity activity) {
		// First filter : Activity' section should equal to Child' section
		// Second filter : Activity is not full
		// Third filter : Activity not yet inscribed by the child
		return activity.getSectionAllowed() == child.getSection()
				&& activity.getMaxNumChildAllowed() > activity.getChildrenInscribed().size()
				&& !child.getActivities().stream().anyMatch(a -> a.getId().equals(activity.getId()));
	}

}
