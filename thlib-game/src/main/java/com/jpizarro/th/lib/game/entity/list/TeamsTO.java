package com.jpizarro.th.lib.game.entity.list;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.jpizarro.th.lib.game.entity.TeamTO;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("teamlist")
@Root
public class TeamsTO {
	@Element(required=false)
	private Integer count;
	
	@Element(required=false)
	private Integer start;
	
	@Element(required=false)
	private Integer total;
	
	@ElementList(required=false)
	private List<TeamTO> teams;
//	private Users users;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<TeamTO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamTO> teams) {
		this.teams = teams;
	}
	public void addTeam(TeamTO t){
		this.addTeam(t);
	}
//	public Users getUsers() {
//		return users;
//	}
//	public void setUsers(Users users) {
//		this.users = users;
//	}
}
