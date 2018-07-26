package com.example.exercise3.model;

import java.util.List;

public class UserStatisticsEntity {
	private UserEntity user;
	private List<GameEntity> playedGames;
	private int rankingPoints;

	public UserStatisticsEntity(UserEntity user, List<GameEntity> playedGames, int rankingPoints) {

		this.user = user;
		this.playedGames = playedGames;
		this.rankingPoints = rankingPoints;

	}

	public UserStatisticsEntity() {

	}

	public UserEntity getUser() {
		return user;
	}

	public void setUserEntity(UserEntity user) {
		this.user = user;
	}

	public List<GameEntity> getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(List<GameEntity> playedGames) {
		this.playedGames = playedGames;
	}

	public int getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

}
