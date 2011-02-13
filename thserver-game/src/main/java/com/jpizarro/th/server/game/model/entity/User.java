package com.jpizarro.th.server.game.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.AccessType;

@Entity
public class User {

	private long userId;
	
	private Set<Place> placesICanSee = new HashSet<Place>();
	
	public User() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
            generator="UserIdGenerator")
    @SequenceGenerator(             // It only takes effect for
            name="UserIdGenerator", // databases providing identifier
            sequenceName="UserSeq") // generators.
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@ManyToMany(
			fetch = FetchType.LAZY,
			targetEntity = Place.class, // no es necesario
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "UserSeePlace",
			joinColumns = @JoinColumn(name = "userId"),
			inverseJoinColumns = @JoinColumn(name = "placeId"))
	@AccessType("field")
	public Set<Place> getPlacesICanSee() {
		return placesICanSee;
	}

	public void setPlacesICanSee(Set<Place> placesICanSee) {
		this.placesICanSee = placesICanSee;
	}
	
	public void addPlaceICanSee(Place place) {
		this.placesICanSee.add(place);
	}

}
