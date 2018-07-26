package com.example.exercise3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exercise3.model.GameEntity;
import com.example.exercise3.model.GameTO;
import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserMapper;
import com.example.exercise3.model.UserStatisticsEntity;
import com.example.exercise3.model.UserStatisticsTO;
import com.example.exercise3.model.UserTO;
import com.example.exercise3.repository.UserRepository;

@Service
public class UserService {
	
	private UserMapper userMapper;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GameService gameService;

	@Autowired //gdy jeden konstruktor to adnotacja jest zbedna
	public UserService(UserMapper userMapper, UserRepository userRepository, GameService gameService) {
	
		this.userMapper = userMapper;
		this.userRepository = userRepository;
		this.gameService = gameService;
	}
	
	public List<UserTO> findAll() {
		List<UserTO> userTOList = new ArrayList<>();
		for(int i=0; i<userRepository.findAll().size(); i++) {
			userTOList.add(userMapper.mapToTransportObject(userRepository.findAll().get(i)));
		}
		return userTOList;
	}
	
	

	public UserTO findById(long id) {
		UserTO userTo=userMapper.mapToTransportObject(userRepository.findById(id));
		return userTo;
	}
	//metoda edit (id usera i obiekt usera, zeby go podmienic)
	public UserStatisticsTO findStatisticsById(long id) {
		UserTO currentUser = findById(id);
		List<GameTO> gamesPlayedByUser = this.gameService.findGamesPlayedByUser(currentUser);
		int rankingPoints = calculateRankingPoints(currentUser, gamesPlayedByUser);
		return new UserStatisticsTO(currentUser, gamesPlayedByUser, rankingPoints);
	}
	private int calculateRankingPoints(UserTO user, List<GameTO> gamesPlayedByUser) {
		
		return gamesPlayedByUser.stream()
				.map(game -> game.getUserPoints()) //na strumieniu sa mapy typu user i ilosc punktow
				.map(e -> e.entrySet()) //pobieramy z mapy zbior laczacy klucze i elementy
				.flatMap(e -> e.stream()) //tu odwoluje sie do 1 listy, ktora sklada sie z poprzednich elementow
				.filter(e -> e.getKey().equals(user)) // mam elemanty typu user liczba punktow, dla zadanego usera w metodzie
				.mapToInt(e -> e.getValue()) //z gier rozegranych przez usera wyciagamy punkty
				.sum();
		
	}
	public void editFirstName(long id, String newName) {
		UserEntity newEntityName = userMapper.mapToEntity(new UserTO(id, newName, null, null, null, null, null));
		userRepository.updateUserFirstName(newEntityName);	
		
	}
	public void editLastName(long id, String newLastName) {
		UserEntity newEntityLastName = userMapper.mapToEntity(new UserTO(id, null, newLastName, null, null, null, null));
		userRepository.updateUserLastName(newEntityLastName);
		
	}
	
	public void editEmail(long id, String newEmail) {
		
		UserEntity newEntityEmail = userMapper.mapToEntity(new UserTO(id, null, null, null, null, newEmail, null));
		userRepository.updateUserEmail(newEntityEmail);
		
	}
	public void editPassword(long id, String newPassword) {
		UserEntity newEntityPassword = userMapper.mapToEntity(new UserTO(id, null, null, null, newPassword, null, null));
		userRepository.updateUserPassword(newEntityPassword);
		
	}
	public void editLifeMotto(long id, String newLifeMotto) {
		UserEntity newEntityLifeMotto = userMapper.mapToEntity(new UserTO(id, null, null,newLifeMotto, null, null, null));
		userRepository.updateUserLastName(newEntityLifeMotto);
		
	}
	
	

}
