package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user")
@Root(name="user")
public class UserTO implements Serializable{

	@Element(required=false)
	private long userId;
	@Element(required=false)
	private long teamId;
	@Element(required=false)
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
