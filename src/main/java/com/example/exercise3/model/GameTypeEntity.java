package com.example.exercise3.model;

public class GameTypeEntity {

	private String gameTypeName;
	private int minPlayers;
	private int maxPlayers;
	
	public GameTypeEntity(String gameTypeName, int minPlayers, int maxPlayers) {
		
		this.gameTypeName = gameTypeName;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
	}

	public GameTypeEntity() {
		
	}

	public String getGameTypeName() {
		return gameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		this.gameTypeName = gameTypeName;
	}

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	
}
