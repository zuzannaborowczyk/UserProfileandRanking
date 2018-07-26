package com.example.exercise3.repository;

import java.util.List;

import com.example.exercise3.model.GameTypeEntity;

public interface GameTypeRepository {

	List<GameTypeEntity> findAllGameTypes();
	GameTypeEntity findGameTypeByName(String gameTypeName);
	void createNewGameType(GameTypeEntity newGameType);
	void reset();
	void initializeGameTypeList();
	
}
