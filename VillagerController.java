package com.qa.stardewproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.stardewproject.domain.Villager;
import com.qa.stardewproject.service.villager.VillagerService;

@RestController

@CrossOrigin


public class VillagerController {

	private VillagerService service;

	public VillagerController(VillagerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addVillager")
	public ResponseEntity<Villager> addVillager(@RequestBody Villager villager) {
		return new ResponseEntity<Villager>(this.service.addVillager(villager), HttpStatus.CREATED);
	}

	@GetMapping("/getVillagers")
	public ResponseEntity<List<Villager>> getVillager() {
		return ResponseEntity.ok(this.service.getVillager());
	}

	@GetMapping("/getVillager/{id}")
	public Villager getVillagerById(@PathVariable Long id) {
		return this.service.getVillagerById(id);
	}

	@DeleteMapping("/removeVillager/{id}")
	public boolean removeVillager(@PathVariable Long id) {
		return this.service.removeVillager(id);
	}

	@PutMapping("updateVillager/{id}")
	public Villager updateVillager(@PathVariable Long id, @RequestBody Villager newVillager) {
		return this.service.updateVillager(id, newVillager);
	}

}
