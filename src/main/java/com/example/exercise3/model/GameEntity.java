package com.example.exercise3.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class GameEntity {
	private long gameId;
	private String gameName;
	private GameStatus status;
	private Map<UserEntity, Integer> userPoints;
	private LocalDate startingDate;
	private LocalDate endDate;
	private UserEntity owner;
	
	
	
	public GameEntity(long gameId, String gameName, GameStatus status, UserEntity owner) {
		
		this.gameId = gameId;
		this.gameName = gameName;
		this.status = status;
	}
	
	
	public GameEntity() {
		
	}
	//doloz metode getUsers ktora by zwracala liste uzytkownikow
	public void addUser(UserEntity user) {
		if(user == null) {
			throw new UserDoesNotExistException("User can not be null");
		}
		if(userPoints.containsKey(user)) {
			throw new UserAlreadyInGameException("User already in game");
		}
		userPoints.put(user, 0);
	}
	public void addPoints(UserEntity user, int points) {
		if(user == null) {
			throw new UserDoesNotExistException("User can not be null");
		}
		if(!userPoints.containsKey(user)) {
			throw new UserNotInGameException("User must be present in game");
		}
		int currentPoints = userPoints.get(user);
		userPoints.put(user, currentPoints+points);
		
		
	}
	

	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public GameStatus getStatus() {
		return status;
	}
	public void setStatus(GameStatus status) {
		this.status = status;
	}
	public Map<UserEntity, Integer> getUserPoints() {
		return userPoints;
	}
	public void setUserPoints(Map<UserEntity, Integer> userPoints) {
		this.userPoints = userPoints;
	}
	public LocalDate getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public UserEntity getOwner() {
		return owner;
	}


	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	
}
