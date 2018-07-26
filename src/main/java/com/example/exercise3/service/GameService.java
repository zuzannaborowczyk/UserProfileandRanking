package com.example.exercise3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exercise3.model.GameEntity;
import com.example.exercise3.model.GameMapper;
import com.example.exercise3.model.GameTO;
import com.example.exercise3.model.GameTypeEntity;
import com.example.exercise3.model.GameTypeMapper;
import com.example.exercise3.model.GameTypeTO;
import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserMapper;
import com.example.exercise3.model.UserTO;
import com.example.exercise3.repository.GameRepository;
import com.example.exercise3.repository.GameTypeRepository;

@Service
public class GameService {

	private GameTypeMapper gameTypeMapper;
	private GameTypeRepository gameTypeRepository;
	private UserMapper userMapper;
	private GameMapper gameMapper;
	private GameRepository gameRepository;

	@Autowired
	public GameService(GameTypeMapper gameTypeMapper, GameTypeRepository gameTypeRepository, UserMapper userMapper,
			GameMapper gameMapper, GameRepository gameRepository) {
		
		this.gameTypeMapper = gameTypeMapper;
		this.gameTypeRepository = gameTypeRepository;
		this.userMapper = userMapper;
		this.gameMapper = gameMapper;
		this.gameRepository = gameRepository;
	}

	// zwrocenie listy (historii gier) w ktore gral user
	public List<GameTO> findGamesPlayedByUser(UserTO user) {
		UserEntity currentUser = userMapper.mapToEntity(user);
		List<GameTO> gameTOList = new ArrayList<>();
		for (int i = 0; i < gameRepository.findByUser(currentUser).size(); i++) {
			gameTOList.add(gameMapper.mapToTransportObject(gameRepository.findByUser(currentUser).get(i)));
		}
		return gameTOList;
	}

	

	// zwrocenie listy gier, ktore user posiada
	public List<GameTO> findGamesOwnedByUser(UserTO owner) {
		UserEntity currentOwner = userMapper.mapToEntity(owner);
		List<GameTO> ownersTOList = new ArrayList<>();
		for (int i = 0; i < gameRepository.findGamesByOwner(currentOwner).size(); i++) {
			ownersTOList.add(gameMapper.mapToTransportObject(gameRepository.findGamesByOwner(currentOwner).get(i)));
		}
		return ownersTOList;

	}

	// usuniecie gry ze swojej kolekcji
	public void removeFromOwnersList(GameTO gameToDelete, UserTO owner) {
		GameEntity currentGame = gameMapper.mapToEntity(gameToDelete);
		UserEntity currentUser = userMapper.mapToEntity(owner);
		gameRepository.removeGameFromOwnersList(currentGame, currentUser);
	}

	// dodanie gry do swojej kolekcji
	public void addGameToOwnersList(GameTO newGame, UserTO owner) {
		GameEntity currentGame = gameMapper.mapToEntity(newGame);
		UserEntity currentOwner = userMapper.mapToEntity(owner);
		gameRepository.addGameToOwnersList(currentGame, currentOwner);
	}

	// zwrocenie listy wszystkich typow gry
	public List<GameTypeTO> showListOfAllGameTypes() {
		List<GameTypeTO> gameTypeTOList = new ArrayList<>();
		for (int i = 0; i < gameTypeRepository.findAllGameTypes().size(); i++) {
			gameTypeTOList.add(gameTypeMapper.mapToTransportObject(gameTypeRepository.findAllGameTypes().get(i)));
		}
		return gameTypeTOList;

	}
	
	//stworzenie nowej gry
	public void createNewGameType(GameTypeTO newGameType) {
		GameTypeEntity newTypeOfGame = gameTypeMapper.mapToEntity(newGameType);
		gameTypeRepository.createNewGameType(newTypeOfGame);
	}

	// metoda remove game(obiekt game i user) czy user jest wlascicielem i jesli
}
