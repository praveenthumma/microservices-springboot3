package com.tp.ms.product;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

	@LocalServerPort
	private Integer port;


	@BeforeEach
	void setup() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static{
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
					"name" : "Product 1",
					"description" : "Product 1 description",
					"price" : 100.00
				}
				""";

		RestAssured.given()
				.contentType(requestBody)
				.body(requestBody)
				.contentType("application/json")
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("name", Matchers.equalTo("Product 1"))
				.body("description", Matchers.equalTo("Product 1 description"))
				.body("id", Matchers.notNullValue())
				.body("price", Matchers.equalTo(100.00f));
	}
}
