package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user")
public class UserTO implements Serializable{

	private long userId;
	private long teamId;
	private long gameId;

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getTeamId() {
		return teamId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public long getGameId() {
		return gameId;
	}
}
