package com.example.exercise3.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.exercise3.model.GameTypeEntity;

@Repository
public class GameTypeRepositoryInMemory implements GameTypeRepository {

	List<GameTypeEntity> gameTypeList;
	
	
	
	public GameTypeRepositoryInMemory() {
		
		this.gameTypeList = new ArrayList<>();
		initializeGameTypeList(); 
		
		
	}
	public void reset(){
		gameTypeList.clear();
	}
	public void initializeGameTypeList() {
		
			gameTypeList.add(new GameTypeEntity("szachy", 2, 2));
			gameTypeList.add(new GameTypeEntity("kalambury", 2, 10));
			gameTypeList.add(new GameTypeEntity("wojna", 2, 4));
			gameTypeList.add(new GameTypeEntity("biedronki", 4, 8));
			gameTypeList.add(new GameTypeEntity("bierki", 2, 10));
			
		
	}
	@Override
	public List<GameTypeEntity> findAllGameTypes() {
		List<GameTypeEntity> gameTypeCopy = new ArrayList<>();
		Collections.copy(gameTypeCopy, gameTypeList);
		return gameTypeCopy;
	}

	@Override
	public GameTypeEntity findGameTypeByName(String gameTypeName) {
		
		return gameTypeList.stream()
				.filter(gameType -> gameType.getGameTypeName().equals(gameTypeName))
				.findFirst()
				.orElseGet(() -> {
					throw new NoSuchGameTypeException("There is no such game in the system: " + gameTypeName);
					
				});
	}

	@Override
	public void createNewGameType(GameTypeEntity newGameType) {
	
		if(!gameTypeList.contains(newGameType)) {
			gameTypeList.add(newGameType);
		} else {
			throw new GameTypeAlreadyExistsException("This gametype already exists " + newGameType);
		}
		
	}

}
