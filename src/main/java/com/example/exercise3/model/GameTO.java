package com.example.exercise3.model;

import java.time.LocalDate;
import java.util.Map;

public class GameTO {

	private long gameId;
	private String gameName;
	private GameStatus status;
	private Map<UserEntity, Integer> userPoints;
	private LocalDate startingDate;
	private LocalDate endDate;
	private UserEntity owner;

	public GameTO(long gameId, String gameName, GameStatus status, Map<UserEntity, Integer> userPoints,
			LocalDate startingDate, LocalDate endDate, UserEntity owner) {

		this.gameId = gameId;
		this.gameName = gameName;
		this.status = status;
		this.userPoints = userPoints;
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.owner = owner;
	}

	public GameTO() {

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
