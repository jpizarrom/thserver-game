package com.jpizarro.th.server.game.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.AccessType;

@Entity
public class Team {
	private long teamId;
	private String name;
	private String description;
	private Game game;
	
//	private Set<User> users = new HashSet<User>();
//
	private Set<Place> placesICanSee = new HashSet<Place>();
	private Set<Place> placesIHave = new HashSet<Place>();
	
	public Team() {}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="TeamIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="TeamIdGenerator", // databases providing identifier
            sequenceName="TeamSeq") // generators.
	public long getTeamId() {
		return teamId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gameId")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

//	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
//	
//	public void addUser(User user) {
//		this.users.add(user);
//		user.setTeam(this);
//	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			targetEntity = Place.class, // no es necesario
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "TeamSeePlace",
			joinColumns = @JoinColumn(name = "teamId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	@AccessType("field")
	public Set<Place> getPlacesICanSee() {
		return placesICanSee;
	}

	public void setPlacesICanSee(Set<Place> placesICanSee) {
		this.placesICanSee = placesICanSee;
	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			targetEntity = Place.class, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "TeamHasPlace",
			joinColumns = @JoinColumn(name = "teamId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	public Set<Place> getPlacesIHave() {
		return placesIHave;
	}

	public void setPlacesIHave(Set<Place> placesIHave) {
		this.placesIHave = placesIHave;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", description="
				+ description + ", game=" + game + "]";
	}


}
