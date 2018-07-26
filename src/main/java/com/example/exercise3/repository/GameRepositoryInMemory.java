package com.example.exercise3.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.exercise3.model.GameEntity;
import com.example.exercise3.model.UserEntity;

@Repository
public class GameRepositoryInMemory implements GameRepository {

	private List<GameEntity> games;

	public GameRepositoryInMemory() {
		this.games = new ArrayList<>();
	}

	@Override
	public List<GameEntity> findAll() {
		List<GameEntity> gamesCopy = new ArrayList<>();
		Collections.copy(gamesCopy, games);
		return gamesCopy;
	}

	// metoda zwraca liste gier, w ktorych bral udzial
	@Override
	public List<GameEntity> findByUser(UserEntity user) {
		return games.stream()
				.filter(game -> game.getUserPoints().containsKey(user))
				.collect(Collectors.toList());

	}

	@Override
	public List<GameEntity> findGamesByOwner(UserEntity owner) {

		return games.stream()
				.filter(game -> game.getOwner() == owner)
				.collect(Collectors.toList());

	}

	@Override
	public void removeGameFromOwnersList(GameEntity gameToDelete, UserEntity owner) {
		List<GameEntity> ownersListOfGames = findGamesByOwner(owner);
		boolean canBeDeleted = false;
		for (int i = 0; i < ownersListOfGames.size(); i++) {
			if (ownersListOfGames.get(i) == gameToDelete) {
				canBeDeleted = true;
			}
			if (canBeDeleted) {
				ownersListOfGames.remove(gameToDelete);
			}
		}
	}
	@Override
	public void addGameToOwnersList(GameEntity gameToAdd, UserEntity owner) {
		List<GameEntity> ownersListOfGames = findGamesByOwner(owner);
		boolean canBeAdded = false;

		if (!ownersListOfGames.contains(gameToAdd)) {
			canBeAdded = true;
		}
		if (canBeAdded) {
			ownersListOfGames.add(gameToAdd);
		}
		throw new GameAlreadyInOwnersListException("You already own game " + gameToAdd);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		games.clear();
		
	}

	
	// zaimplementowac remove i findgamesbyowner(filtrowac tylko tych w ktorych
	// owner zgadza sie z tym, ktory zadalam w metodzie) i save(dodanie gry do
	// systemu), save basedOn(game i user)
}
