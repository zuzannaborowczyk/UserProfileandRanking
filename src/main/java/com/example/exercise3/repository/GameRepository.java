package com.example.exercise3.repository;

import java.util.List;

import com.example.exercise3.model.GameEntity;
import com.example.exercise3.model.UserEntity;
import com.example.exercise3.model.UserTO;

public interface GameRepository {

	List<GameEntity> findAll();
	List<GameEntity> findByUser(UserEntity user);
	List<GameEntity> findGamesByOwner(UserEntity owner);
	void removeGameFromOwnersList(GameEntity gameToDelete, UserEntity owner);
	void addGameToOwnersList(GameEntity gameToAdd, UserEntity owner);
	void initialize();
	void reset();
	
}
