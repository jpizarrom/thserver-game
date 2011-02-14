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

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getTeamId() {
		return teamId;
	}

}
