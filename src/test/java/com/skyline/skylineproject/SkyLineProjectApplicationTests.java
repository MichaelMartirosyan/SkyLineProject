package com.skyline.skylineproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skyline.skylineproject.api.Request;

import com.skyline.skylineproject.entity.Billionaires;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class SkyLineProjectApplicationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void restControllerTest(){
		String url = "http://localhost:" + port + "/select";
		Request request = new Request();
		request.setTableName("tableName");
		HttpStatus statusCode = testRestTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(request), Void.class).getStatusCode();
		assertEquals(HttpStatus.OK,statusCode,"Получили неверный код ответа");
		System.out.println("b");
	}

	@Test
	public void jsonConvert() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Request request = new Request();
		request.setTableName("tableName");
		objectMapper.writeValueAsString(request);
	}

	@Test
	public void h2Test(){
		List<Billionaires> query = jdbcTemplate.query("select * from billionaires", new BeanPropertyRowMapper<>(Billionaires.class));
		assertEquals(query.size(), 3); //TODO add normal assertions to check data
	}



}
