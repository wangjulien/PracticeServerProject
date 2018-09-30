package org.formation.ajc.family.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.model.Parent;
import org.formation.ajc.family.model.Person.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class TestFamilyRepository {

	@Autowired
	private FamilyRepository familyRepository;

	private Family family;

	@BeforeEach
	public void setupData() {
		family = new Family();

		Parent father = new Parent();
		father.setGender(Gender.MALE);
		father.setFirstName("SomeFather");
		father.setLastName("SURNAME");
		father.setAge(30);

		Parent mother = new Parent();
		mother.setGender(Gender.FEMALE);
		mother.setFirstName("SomeMother");
		mother.setLastName("SURNAME");
		mother.setAge(25);

		family.addParent(father);
		family.addParent(mother);

		Child child = new Child();
		child.setGender(Gender.FEMALE);
		child.setFirstName("SomeChild");
		child.setLastName("SURNAME");
		child.setAge(3);

		family.addChild(child);

		familyRepository.save(family);
	}

	@Test
	public void family_saved_can_be_found() {
		Family familyFound = familyRepository.findById(family.getId()).orElseThrow(EntityNotFoundException::new);

		assertEquals(2, familyFound.getParents().size());
		assertEquals(1, familyFound.getChildren().size());
	}
}
