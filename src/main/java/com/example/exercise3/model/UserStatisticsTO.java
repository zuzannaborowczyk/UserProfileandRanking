package com.example.exercise3.model;

import java.util.List;

public class UserStatisticsTO {

	private UserTO user;
	private List<GameTO> playedGames;
	private int rankingPoints;

	public UserStatisticsTO(UserTO user, List<GameTO> playedGames, int rankingPoints) {

		this.user = user;
		this.playedGames = playedGames;
		this.rankingPoints = rankingPoints;

	}

	public UserStatisticsTO() {

	}

	public UserTO getUser() {
		return user;
	}

	public void setUser(UserTO user) {
		this.user = user;
	}

	public List<GameTO> getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(List<GameTO> list) {
		this.playedGames = list;
	}

	public int getRankingPoints() {
		return rankingPoints;
	}

	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

}



