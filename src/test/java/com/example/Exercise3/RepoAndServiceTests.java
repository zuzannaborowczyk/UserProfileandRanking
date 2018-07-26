package com.example.Exercise3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exercise3.model.GameTypeTO;
import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserMapper;
import com.example.exercise3.model.UserTO;
import com.example.exercise3.repository.GameTypeRepositoryInMemory;
import com.example.exercise3.repository.UserRepository;
import com.example.exercise3.repository.UserRepositoryInMemory;
import com.example.exercise3.service.GameService;
import com.example.exercise3.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepoAndServiceTests {

	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRepositoryInMemory userRepositoryInMemory;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserService userService;
	@Autowired
	private GameTypeRepositoryInMemory gameTypeRepositoryInMemory;
	
	
	
	
	@Test
	public void shouldReturnUserProfile(){
		//given
		userRepositoryInMemory.initialize();
		
		
		//when		
		UserTO result = userService.findById(2L);
		
		
	
		//then
		//assertTrue("Marek".equals(result.getFirstName()));
		assertEquals("Marek", userRepositoryInMemory.findById(2L).getFirstName());
		
		
	}
	
	@Test
	public void shouldChangeUserEmail(){
		//given
		userRepositoryInMemory.initialize();
		
		
		//when
		 userService.editEmail(2L, "m.lewan@op.pl");
		
		
		//then
		assertTrue("m.lewan@op.pl".equals(result.getEmail()));
		
		
	}
	@Test
	public void shouldShowExistingGameTypes(){
		//given
		
		gameTypeRepositoryInMemory.initializeGameTypeList();
		
		
		//when
		int result = gameService.showListOfAllGameTypes().get(3).getMaxPlayers();
		
		
		//then
		assertEquals(8,result);
		
		
	}
	
	
}

