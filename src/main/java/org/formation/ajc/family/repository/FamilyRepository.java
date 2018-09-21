package org.formation.ajc.family.repository;

import org.formation.ajc.family.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
	
}
