package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

public class TeamTO implements Serializable {

	private long teamId;

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getTeamId() {
		return teamId;
	}

}
