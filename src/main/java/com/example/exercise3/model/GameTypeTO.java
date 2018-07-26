package com.example.exercise3.model;

public class GameTypeTO {

	private String GameTypeName;
	private int minPlayers;
	private int maxPlayers;
	
	public GameTypeTO(String gameTypeName, int minPlayers, int maxPlayers) {
		super();
		GameTypeName = gameTypeName;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
	}

	public GameTypeTO() {
		
	}

	public String getGameTypeName() {
		return GameTypeName;
	}

	public void setGameTypeName(String gameTypeName) {
		GameTypeName = gameTypeName;
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
