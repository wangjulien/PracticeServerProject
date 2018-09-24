package org.formation.ajc.family;

import org.formation.ajc.family.model.Address;
import org.formation.ajc.family.model.Child;
import org.formation.ajc.family.model.Child.Section;
import org.formation.ajc.family.model.Family;
import org.formation.ajc.family.model.Parent;
import org.formation.ajc.family.model.Person.Gender;
import org.formation.ajc.family.repository.FamilyRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	// private final UserRepository userRepository;
	private final FamilyRepository familyRepository;
	// private final PasswordEncoder passwordEncoder;

	public SetupDataLoader(
			// UserRepository userRepository,
			FamilyRepository familyRepository) {
		super();
		// this.userRepository = userRepository;
		this.familyRepository = familyRepository;
		// this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;

		// Admin User
		// User adminUser = new User();
		// adminUser.setUsername("admin");
		// adminUser.setPassword(passwordEncoder.encode("test"));
		// createUserIfNotFound(adminUser);

		// Add familys
		Address address = new Address("7, av champes-elysse", 75001, "Paris");
		for (int i = 0; i < 10; i++) {
			Family family = new Family();
			family.setAddress(address);

			Parent father = new Parent();
			father.setGender(Gender.MALE);
			father.setFirstName("SomeFather - 0" + i);
			father.setLastName("SURNAME - A0" + i);
			father.setAge(30 + i);

			Parent mother = new Parent();
			mother.setGender(Gender.FEMALE);
			mother.setFirstName("SomeMother - 0" + i);
			mother.setLastName("SURNAME - B0" + i);
			mother.setAge(25 + i);

			family.addParent(father);
			family.addParent(mother);

			for (int j = 0; j < 3; j++) {
				Child child = new Child();
				child.setGender((int) (Math.random() + 0.5) == 0 ? Gender.FEMALE : Gender.MALE);
				child.setFirstName("SomeChild - 0" + i);
				child.setLastName("SURNAME - B0" + i);
				child.setAge(j + 1);
				switch (j) {
				case 0:
					child.setSection(Section.PETIT);
					break;
				case 1:
					child.setSection(Section.MOYEN);
					break;
				case 2:
					child.setSection(Section.GRAND);
					break;
				}

				family.addChild(child);
			}

			familyRepository.save(family);
		}

		alreadySetup = true;
	}

	// private User createUserIfNotFound(User newUser) {
	//
	// Optional<User> optUser =
	// userRepository.findByUsername(newUser.getUsername());
	//
	// return optUser.orElseGet(() -> userRepository.save(newUser));
	// }
}