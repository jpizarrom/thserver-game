package com.jpizarro.th.server.game.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.AccessType;

import com.jpizarro.th.server.game.model.entity.Game;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Place {
	private long placeId;
	
	private Game game;
	private String type = new String();
	
	private Set<Team> teamsCanSeeMe = new HashSet<Team>();
	private Set<Team> teamsHaveMe = new HashSet<Team>();
	
	private Set<User> usersCanSeeMe = new HashSet<User>();
	
	public Place() {
		super();
	}

	public Place(Game game) {
		super();
		this.game = game;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="PlaceIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="PlaceIdGenerator", // databases providing identifier
            sequenceName="PlaceSeq") // generators.
	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gameId")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			mappedBy = "placesICanSee",
			targetEntity = Team.class)
	@AccessType(value = "field")
	public Set<Team> getTeamsCanSeeMe() {
		return teamsCanSeeMe;
	}

	public void setTeamsCanSeeMe(Set<Team> teamsCanSeeMe) {
		this.teamsCanSeeMe = teamsCanSeeMe;
	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			mappedBy = "placesIHave",
			targetEntity = Team.class)
	public Set<Team> getTeamsHaveMe() {
		return teamsHaveMe;
	}

	public void setTeamsHaveMe(Set<Team> teamsHaveMe) {
		this.teamsHaveMe = teamsHaveMe;
	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			mappedBy = "placesICanSee",
			targetEntity = User.class)
	@AccessType(value = "field")
	public Set<User> getUsersCanSeeMe() {
		return usersCanSeeMe;
	}

	public void setUsersCanSeeMe(Set<User> usersCanSeeMe) {
		this.usersCanSeeMe = usersCanSeeMe;
	}
	
	public void addTeamCanSeeMe(Team t){
		this.teamsCanSeeMe.add(t);
	}
	public void addTeamHaveMe(Team t){
		this.teamsHaveMe.add(t);
	}
	public void addUserCanSeeMe(User user) {
		this.usersCanSeeMe.add(user);
	}
}
