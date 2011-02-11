package com.jpizarro.th.server.game.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

	private long userId;
//	private String username;
//	private String password;
//	private String email;
////	private PersonalInformation personalInformation;
//	private String role;
//	private Team team;
//	private boolean showPersonalInfo = false;
//	private int latitude;
//	private int longitude;
//	
//	private String name;
//	private String phone;
//	private String surname;
//	private String country;
	
	private Set<Place> placesICanSee = new HashSet<Place>();
	
	public User() {
	}
	
//	public User(long userId, String username, String password, String role) {
//		super();
//		this.userId = userId;
//		this.username = username;
//		this.password = password;
//		this.role = role;
//	}
//
//	public User(String username, String password, String email, String role) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.role = role;
//	}
//
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

//	public String getEmail() {
//	return email;
//}
//
//public void setEmail(String email) {
//	this.email = email;
//}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public PersonalInformation getPersonalInformation() {
//		return personalInformation;
//	}
//
//	public void setPersonalInformation(PersonalInformation personalInformation) {
//		this.personalInformation = personalInformation;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "teamId")
//	public Team getTeam() {
//		return team;
//	}
//
//	public void setTeam(Team team) {
//		this.team = team;
//	}
//
//	public void setLatitude(int latitude) {
//		this.latitude = latitude;
//	}
//
//	public int getLatitude() {
//		return latitude;
//	}
//
//	public void setLongitude(int longitude) {
//		this.longitude = longitude;
//	}
//
//	public int getLongitude() {
//		return longitude;
//	}
//	
//	@ManyToMany(
//			fetch = FetchType.LAZY,
//			targetEntity = Place.class, // no es necesario
//			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(
//			name = "UserSeePlace",
//			joinColumns = @JoinColumn(name = "userId"),
//			inverseJoinColumns = @JoinColumn(name = "placeId"))
//	@AccessType("field")
//	public Set<Place> getPlacesICanSee() {
//		return placesICanSee;
//	}
//
//	public void setPlacesICanSee(Set<Place> placesICanSee) {
//		this.placesICanSee = placesICanSee;
//	}
//
//	@Override
//	public String toString() {
//		return "User [latitude=" + latitude + ", longitude=" + longitude
//				+ ", password=" + password + ", role=" + role + ", team="
//				+ team + ", userId=" + userId + ", userName=" + username + "]";
//	}
//
//	public void setShowPersonalInfo(boolean showPersonalInfo) {
//		this.showPersonalInfo = showPersonalInfo;
//	}
//
//	public boolean isShowPersonalInfo() {
//		return showPersonalInfo;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}
//
//	public String getSurname() {
//		return surname;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public String getCountry() {
//		return country;
//	}
	

}
