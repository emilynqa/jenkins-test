package com.qa.stardewproject.service.villager;

import java.util.List;

import com.qa.stardewproject.domain.Villager;

public interface VillagerService {

	Villager addVillager(Villager villager);

	List<Villager> getVillager();

	Villager getVillagerById(Long id);

	boolean removeVillager(Long id);

	Villager updateVillager(Long id, Villager newVillager);

	Villager getVillagerByName(String name);

}
