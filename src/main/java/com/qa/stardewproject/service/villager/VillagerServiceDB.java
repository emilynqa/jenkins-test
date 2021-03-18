package com.qa.stardewproject.service.villager;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.stardewproject.domain.Villager;
import com.qa.stardewproject.repo.VillagerRepo;

@Service
public class VillagerServiceDB implements VillagerService {

	private VillagerRepo repo;

	public VillagerServiceDB(VillagerRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Villager addVillager(Villager villager) {
		return this.repo.save(villager);
	}

	@Override
	public List<Villager> getVillager() {
		return this.repo.findAll();
	}

	@Override
	public Villager getVillagerById(Long id) {
		Optional<Villager> optVillager = this.repo.findById(id);
		return optVillager.get();
	}

	@Override
	public Villager getVillagerByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public boolean removeVillager(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

	@Override
	public Villager updateVillager(Long id, Villager newVillager) {

		Optional<Villager> optionalVillager = this.repo.findById(id);
		Villager existing = optionalVillager.get();

		existing.setName(newVillager.getName());
		existing.setBirthDay(newVillager.getBirthDay());
		existing.setBirthSeason(newVillager.getBirthSeason());
		existing.setFaveItem(newVillager.getFaveItem());
		existing.setLeastFaveItem(newVillager.getLeastFaveItem());

		return this.repo.save(existing);
	}

}
