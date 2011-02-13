package com.jpizarro.th.server.game.model.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Game {
	
	private long gameId;
	private String name;
	private String description;
	private Calendar startDate;
	private Calendar finishDate;
	private boolean finished = false;
	
	private int maxTeams;
	private int maxUserPerTeam;
	
	private int latitude;
	private int longitude;
	private String city;
	
	private Set<Team> teams = new HashSet<Team>();
	private Set<Place> places = new HashSet<Place>();
////	private Goal goal;
//	private Set<Message> messages = new HashSet<Message>();
	
	public Game() {}
	
	public Game(int maxTeams, int maxUserPerTeam, String city) {
		super();
		this.maxTeams = maxTeams;
		this.maxUserPerTeam = maxUserPerTeam;
		this.city = city;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="GameIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="GameIdGenerator", // databases providing identifier
            sequenceName="GameSeq") // generators.
	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Calendar finishDate) {
		this.finishDate = finishDate;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
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
	
	@OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
	public Set<Team> getTeams() {
		return teams;
	}
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	public void addTeam(Team team) {
		this.teams.add(team);
		team.setGame(this);
	}

	@OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	
	public void addPlace(Place place) {
		this.places.add(place);
		place.setGame(this);
	}
//
//	public void removePlace(Place place) {
//		this.places.remove(place);
//		place.setGame(null);
//	}	
}
