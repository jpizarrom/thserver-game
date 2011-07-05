package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user")
@Root(name="user")
public class UserTO implements Serializable{

	@Element(required=false)
	private long userId;
//	@Element(required=false)
//	private long teamId;
//	@Element(required=false)
//	private long gameId;
	
	@Element(required=false)
	private com.jpizarro.th.lib.user.entity.UserTO user;
	
	@ElementList(required=false)
	private List<TeamTO> teams = new ArrayList<TeamTO>();

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public List<TeamTO> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamTO> teams) {
		this.teams = teams;
	}

	public com.jpizarro.th.lib.user.entity.UserTO getUser() {
		return user;
	}

	public void setUser(com.jpizarro.th.lib.user.entity.UserTO user) {
		this.user = user;
	}
	
	
}
