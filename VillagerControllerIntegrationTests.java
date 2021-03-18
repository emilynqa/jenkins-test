package com.qa.stardewproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.stardewproject.domain.Villager;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:stardew-schema.sql",
		"classpath:stardew-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VillagerControllerIntegrationTests {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Villager newVillager = new Villager("Shane", 30, "Spring", "Beer", "Mushrooms");
		String newVillagerAsJSON = this.mapper.writeValueAsString(newVillager);
		RequestBuilder mockRequest = post("/addVillager").contentType(MediaType.APPLICATION_JSON)
				.content(newVillagerAsJSON);

		Villager savedVillager = new Villager(2L, "Shane", 30, "Spring", "Beer", "Mushrooms");
		String savedVillagerAsJSON = this.mapper.writeValueAsString(savedVillager);

		ResultMatcher matchStatus = status().isCreated();
		ResultMatcher matchBody = content().json(savedVillagerAsJSON);
		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}

	@Test
	void testRead() throws Exception {

		Villager readVillager = new Villager(1L, "Shane", 20, "spring", "beer", "pickles");

		List<Villager> allVillagers = List.of(readVillager);

		String readVillagerAsJSON = this.mapper.writeValueAsString(allVillagers);

		RequestBuilder mockRequest = get("/getVillagers");

		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(readVillagerAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void deleteTest() throws Exception {

		RequestBuilder mockRequest = delete("/removeVillager/1");

		this.mockMVC.perform(mockRequest).andExpect(status().isOk());
	}

	@Test
	void testUpdate() throws Exception {

		Villager newVillager = new Villager("Update", 4, "Spring", "Fave", "Eugh");

		String newVillagerAsJSON = this.mapper.writeValueAsString(newVillager);

		RequestBuilder mockRequest = put("/updateVillager/1").contentType(MediaType.APPLICATION_JSON)
				.content(newVillagerAsJSON);

		Villager savedVillager = new Villager(1L, "Update", 4, "Spring", "Fave", "Eugh");
		String savedVillagerAsJSON = this.mapper.writeValueAsString(savedVillager);

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedVillagerAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);

	}

}
