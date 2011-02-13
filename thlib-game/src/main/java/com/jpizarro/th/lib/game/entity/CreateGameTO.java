package com.jpizarro.th.lib.game.entity;


import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("creategame")
public class CreateGameTO {
	private long gameId;
	private Calendar startDate;
	private Calendar finishDate;
	
	private int maxTeams;
	private int maxUserPerTeam;
	
	private int latitude;
	private int longitude;
	private String city;

	private Set<PlaceTO> places = new HashSet<PlaceTO>();

	
	
	public CreateGameTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateGameTO(long gameId, Calendar startDate, Calendar finishDate,
			int maxTeams, int maxUserPerTeam, int latitude, int longitude,
			String city, Set<PlaceTO> places) {
		super();
		this.gameId = gameId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.maxTeams = maxTeams;
		this.maxUserPerTeam = maxUserPerTeam;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.places = places;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}

	public int getMaxTeams() {
		return maxTeams;
	}

	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}

	public int getMaxUserPerTeam() {
		return maxUserPerTeam;
	}

	public void setMaxUserPerTeam(int maxUserPerTeam) {
		this.maxUserPerTeam = maxUserPerTeam;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<PlaceTO> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceTO> places) {
		this.places = places;
	}

}
