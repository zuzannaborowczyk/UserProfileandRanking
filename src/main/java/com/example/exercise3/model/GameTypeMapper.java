package com.example.exercise3.model;

import org.springframework.stereotype.Component;

@Component
public class GameTypeMapper {

	public GameTypeTO mapToTransportObject(GameTypeEntity gE) {
		GameTypeTO result = new GameTypeTO();
		result.setGameTypeName(gE.getGameTypeName());
		result.setMinPlayers(gE.getMaxPlayers());
		result.setMaxPlayers(gE.getMaxPlayers());
		return result;
	}

	public GameTypeEntity mapToEntity(GameTypeTO gT) {
		GameTypeEntity result = new GameTypeEntity();
		result.setGameTypeName(gT.getGameTypeName());
		result.setMinPlayers(gT.getMinPlayers());
		result.setMaxPlayers(gT.getMaxPlayers());
		return result;
	}
}