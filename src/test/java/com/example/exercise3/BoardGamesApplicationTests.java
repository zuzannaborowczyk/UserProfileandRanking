package com.example.exercise3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exercise3.model.UserTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
BoardGamesApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardGamesApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
    public void shouldReturnUserDetailsIfExist() {
        // given
        TestRestTemplate restTemplate = new TestRestTemplate();
        String fooResourceUrl = "http://localhost:8080//usersById";

        // when
        ResponseEntity<UserTO> result = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);

        // then
        assertEquals(result.getStatusCode(), HttpStatus.OK);
        assertEquals("Marek", result.getBody().getFirstName());
    }
	@Test
	public void shouldReturnErrorByEnteringNonExistingUserId() {
		// given
		TestRestTemplate restTemplate = new TestRestTemplate();
		String fooResourceUrl = "/usersById";
		
		// when
		ResponseEntity<UserTO> result = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);
		
		// then
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertEquals("Marek", result.getBody().getFirstName());
	}
	@Test
	public void shouldChangeLifeMottoAndReturnUserDetails() {
		// given
		TestRestTemplate restTemplate = new TestRestTemplate();
		String fooResourceUrl = "/usersById";
		
		// when
		ResponseEntity<UserTO> result = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);
		
		// then
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertEquals("Marek", result.getBody().getFirstName());
	}
	@Test
	public void shouldReturnListOfUsersDetailsByEnteringLastName() {
		// given
		TestRestTemplate restTemplate = new TestRestTemplate();
		String fooResourceUrl = "/usersById";
		
		// when
		ResponseEntity<UserTO> result = restTemplate.getForEntity(fooResourceUrl + "/2", UserTO.class);
		
		// then
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertEquals("Marek", result.getBody().getFirstName());
	}
}
