package com.david.place;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.david.place.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void createPlaceSuccess() {
		var name = "Valid Name";
		var slug = "valid-name";
		var city = "Valid City";
		var state = "Valid State";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, city, state))
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("city").isEqualTo(city)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updatedAt").isNotEmpty();
	}

	@Test
	public void createPlaceFailure() {
		var name = "";
		var city = "";
		var state = "";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, city, state))
				.exchange()
				.expectStatus().isBadRequest();
	}
}
