package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("team")
@Root
public class TeamTO implements Serializable {

	@Element(required=false)
	private long teamId;
	
	@Element(required=false)
	private long gameId;
	
	@Element(required=false)
	private GameTO game;

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getTeamId() {
		return teamId;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public GameTO getGame() {
		return game;
	}

	public void setGame(GameTO game) {
		this.game = game;
	}

}
