package com.qa.stardewproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.stardewproject.domain.Villager;

@Repository
public interface VillagerRepo extends JpaRepository<Villager, Long> {

	Villager findByName(String name);

}
