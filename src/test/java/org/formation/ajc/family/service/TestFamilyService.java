package org.formation.ajc.family.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.repository.FamilyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TestFamilyService {

	@Mock
	private FamilyRepository familyRepository;

	@InjectMocks
	private FamilyService familyService;

	private Family family;

	@BeforeEach
	void setMockOutput() {
		family = new Family();
		when(familyRepository.findById(1L)).thenReturn(Optional.of(family));
	}

	@Test
	public void addchild_should_add_child_in_the_family() {
		Child child = new Child();

		Family familyFound = familyService.addChildToFamily(1L, child);

		assertEquals(1, familyFound.getChildren().size());
	}

}
