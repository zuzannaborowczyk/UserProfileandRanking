package com.example.Exercise3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.exercise3.model.GameEntity;
import com.example.exercise3.model.GameMapper;
import com.example.exercise3.model.GameTypeEntity;
import com.example.exercise3.model.GameTypeMapper;
import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserMapper;
import com.example.exercise3.model.UserTO;
import com.example.exercise3.repository.GameRepository;
import com.example.exercise3.repository.GameRepositoryInMemory;
import com.example.exercise3.repository.GameTypeRepository;
import com.example.exercise3.repository.GameTypeRepositoryInMemory;
import com.example.exercise3.repository.UserRepositoryInMemory;
import com.example.exercise3.service.GameService;
import com.example.exercise3.service.UserService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRepositoryInMemory userRepositoryInMemory;
	@Autowired
	private GameTypeMapper gameTypeMapper;
	@Autowired
	private GameTypeRepository gameTypeRepository;
	@Autowired
	private GameMapper gameMapper;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserService userService;
	
	
	
	@Before
	public void init(){
		
		userRepositoryInMemory.reset();
		userRepositoryInMemory.initialize();
		gameTypeRepository.reset();
		gameTypeRepository.initializeGameTypeList();
		gameRepository.reset();
		gameRepository.initialize();
		
		
		
		
		
	}
	
	
	@Configuration
	static class UserServiceTestConfiguration {
		@Bean
		public UserMapper userMapper() {
			return new UserMapper();
		}
		@Bean
		public UserRepositoryInMemory userRepositoryInMemory() {
			return new UserRepositoryInMemory();
		}
		@Bean
		public GameTypeMapper gameTypeMapper() {
			return new GameTypeMapper();
		}
		@Bean 
		public GameTypeRepositoryInMemory gameTypeRepositoryInMemory() {
			return new GameTypeRepositoryInMemory();
		}
		
		@Bean
		public GameMapper gameMapper() {
			return new GameMapper();
		}
		@Bean
		public GameRepository gameRepository() {
			return new GameRepositoryInMemory(); 
				
				
		}
		
		@Bean
		public GameService gameService() {
			return new GameService(gameTypeMapper(), gameTypeRepositoryInMemory(), userMapper(), gameMapper(), gameRepository());
		}

		
		@Bean
		public UserService userService() {
			return new UserService(userMapper(), userRepositoryInMemory(), gameService());
		}
	}
	
	
	
	
	@Test
	public void shouldReturnUserProfile(){
		//given
		
		
		
		//when		
		UserTO result = userService.findById(2L);
		
		
	
		//then
		assertTrue("Marek".equals(result.getFirstName()));
		assertTrue(2L==result.getUserId());
		//assertEquals("Marek", userRepositoryInMemory.findById(2L).getFirstName());
	
	}
	
	
	
	@Test
	public void shouldReturnUserProfile2(){
		//given
		
		
		
		//when		
		UserTO result = userService.findById(2L);
		
		
	
		//then
		assertTrue("Marek".equals(result.getFirstName()));
		assertTrue(2L==result.getUserId());
		//assertEquals("Marek", userRepositoryInMemory.findById(2L).getFirstName());
	
	}
	
	
	@Test
	public void shouldChangeUserEmail(){
		//given
		
		
		
		//when
		
		UserTO result = userService.findById(2);
		userService.editEmail(2, "m.lewan@op.pl");
		
		
		//then
		assertTrue("m.lewan@op.pl".equals(result.getEmail()));
		
		
	}
	
}
