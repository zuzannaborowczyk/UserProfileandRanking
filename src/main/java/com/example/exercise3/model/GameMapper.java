package com.example.exercise3.model;

import org.springframework.stereotype.Component;

@Component
public class GameMapper {

	public GameTO mapToTransportObject(GameEntity gE) {
		GameTO result = new GameTO();
		result.setGameId(gE.getGameId());
		result.setGameName(gE.getGameName());
		result.setStatus(gE.getStatus());
		result.setUserPoints(gE.getUserPoints());
		result.setStartingDate(gE.getStartingDate());
		result.setEndDate(gE.getEndDate());
		result.setOwner(gE.getOwner());
		return result;

	}

	public GameEntity mapToEntity(GameTO gT) {
		GameEntity result = new GameEntity();
		result.setGameId(gT.getGameId());
		result.setGameName(gT.getGameName());
		result.setStatus(gT.getStatus());
		result.setUserPoints(gT.getUserPoints());
		result.setStartingDate(gT.getStartingDate());
		result.setEndDate(gT.getEndDate());
		result.setOwner(gT.getOwner());
		return result;

	}
}
