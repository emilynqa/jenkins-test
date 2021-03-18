package com.qa.stardewproject.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.stardewproject.domain.Villager;
import com.qa.stardewproject.repo.VillagerRepo;
import com.qa.stardewproject.service.villager.VillagerServiceDB;

@SpringBootTest
@ActiveProfiles("test")
public class VillagerServiceDBUnitTest {

	@Autowired
	private VillagerServiceDB service;

	@MockBean
	private VillagerRepo repo;

	@Test
	void testCreate() {
		Villager newVillager = new Villager("Shane", 20, "Spring", "Beer", "Garbage");
		Villager savedVillager = new Villager(1L, "Shane", 20, "Spring", "Beer", "Garbage");

		Mockito.when(this.repo.save(newVillager)).thenReturn(savedVillager);

		assertThat(this.service.addVillager(newVillager)).isEqualTo(savedVillager);

		Mockito.verify(this.repo, Mockito.times(1)).save(newVillager);

	}

	@Test
	void testUpdate() {

		Long id = 1L;

		Villager newVillager = new Villager("Seb", 27, "Winter", "Diamond", "Garbage");
		Optional<Villager> optionalVillager = Optional.of(new Villager(id, "Name", 5, "Season", "Fave", "LeastFave"));

		Villager updatedVillager = new Villager(id, newVillager.getName(), newVillager.getBirthDay(),
				newVillager.getBirthSeason(), newVillager.getFaveItem(), newVillager.getLeastFaveItem());

		Mockito.when(this.repo.findById(id)).thenReturn(optionalVillager);
		Mockito.when(this.repo.save(updatedVillager)).thenReturn(updatedVillager);

		assertThat(this.service.updateVillager(id, newVillager)).isEqualTo(updatedVillager);

		Mockito.verify(this.repo, Mockito.times(1)).save(updatedVillager);

	}

	@Test
	void testDelete() {

		Long id = 1L;

		Villager newVillager = new Villager("TestName", 5, "TestSeason", "Test Fave", "Test Least Fave");
		Villager savedVillager = new Villager(1L, "TestName", 5, "TestSeason", "Test Fave", "Test Least Fave");

		Mockito.when(this.repo.save(newVillager)).thenReturn(savedVillager);
		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		Mockito.when(this.service.removeVillager(id)).thenReturn(false);

		assertThat(this.service.removeVillager(id)).isFalse();

	}

	@Test
	void testReadAll() {

		Long id = 1L;

		Villager testVillager = new Villager("Test", 2, "Spring", "Fave", "Yuck");
		testVillager.setId(id);
		List<Villager> villagers = List.of(testVillager);

		Mockito.when(this.repo.findAll()).thenReturn(villagers);

		assertThat(this.service.getVillager()).isEqualTo(villagers);

	}

	@Test
	void testReadSpecific() {

		Long id = 1L;

		Villager testVillager = new Villager(id, "Test", 2, "Spring", "Fave", "Yuck");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(testVillager));

		assertThat(this.service.getVillagerById(id)).isEqualTo(testVillager);

	}

}
