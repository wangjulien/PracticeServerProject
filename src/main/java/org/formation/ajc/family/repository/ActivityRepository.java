package org.formation.ajc.family.repository;

import org.formation.ajc.family.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
}
