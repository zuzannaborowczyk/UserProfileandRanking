package com.example.exercise3.service;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserMapper;
import com.example.exercise3.model.UserTO;
import com.example.exercise3.repository.UserRepository;

import java.util.Arrays;
import org.junit.Assert;

public class UserServiceUnitTest {

	UserMapper userMapper = Mockito.spy(UserMapper.class);
	UserRepository userRepository = Mockito.mock(UserRepository.class);
	GameService gameService = Mockito.mock(GameService.class);
	UserService userService = new UserService(userMapper, userRepository, gameService);
	
	@Test
	
	public void searchByFirstName() {
		//given
		
		stubUserRepositorySoItReturnsListWithOnlyFirstNames();
		
		
		
		//when
		List <UserTO> listOfUsers = userService.searchUsersByParameters("Tomek", null, null);
		
		//then
		Assert.assertEquals("Method should return 2 users", 2, listOfUsers.size());
		listOfUsers.stream().forEach(e -> Assert.assertTrue("Given user has different name", "Tomek".equals(e.getFirstName())));
	}
	
	@Test
	public void searchByFirstAndLastName() {
	 //given
		stubUserRepositorySoItReturnsListWithFirstAndLastNames();
		//when
		List <UserTO> listByFirstAndLastName= userService.searchUsersByParameters("Ania", "Sliwka", null);
		//then
		listByFirstAndLastName.stream().forEach(e -> Assert.assertTrue("Ania".equals(e.getFirstName()) && "Sliwka".equals(e.getLastName())));
		Assert.assertEquals(1, listByFirstAndLastName.size());
	}
	
	private void stubUserRepositorySoItReturnsListWithOnlyFirstNames() {
		Mockito.when(userRepository.findAll())
		.thenReturn(Arrays.asList(
				UserEntity.of("Tomek"),
				UserEntity.of("Ania"),
				UserEntity.of("Marek"),
				UserEntity.of("Tomek")));
	}
	private void stubUserRepositorySoItReturnsListWithFirstAndLastNames() {
		Mockito.when(userRepository.findAll())
		.thenReturn(Arrays.asList(
				UserEntity.of("Tomek", "Nowak"),
				UserEntity.of("Ania", "Sliwka"),
				UserEntity.of("Ania", "Kowalska"),
				UserEntity.of("Marek", "Rosiak"),
				UserEntity.of("Tomek", "Kowalski")));
	}
}
