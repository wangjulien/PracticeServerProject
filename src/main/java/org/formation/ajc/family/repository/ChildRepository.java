package org.formation.ajc.family.repository;

import org.formation.ajc.family.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
	
}
