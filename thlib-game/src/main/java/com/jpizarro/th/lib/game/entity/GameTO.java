package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.jpizarro.th.lib.generic.util.xml.xstream.CalendarConverter;

@XStreamAlias("game")
@Root
public class GameTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9042114067071410684L;
	@Element(required=false)
	private long gameId;
	@Element(required=false)
	private String name;
	@Element(required=false)
	private String description;
	
	@XStreamConverter(CalendarConverter.class)
	@Element(required=false)
	private GregorianCalendar startDate;
	
	@XStreamConverter(CalendarConverter.class)
	@Element(required=false)
	private GregorianCalendar finishDate;
	
	@Element(required=false)
	private String city;
	
	@Element(required=false)
	private int availablePlaces;
	@Element(required=false)
	private int availableHints;
	@Element(required=false)
	private int availableGoals;
	
	@Element(required=false)
	private int currentTeams;
	@Element(required=false)
	private int currentUsers;
	@Element(required=false)
	private int currentMessages;
	
	@Element(required=false)
	private int maxTeams;
	@Element(required=false)
	private int maxUserPerTeam;
	
	@Element(required=false)
	private int latitude;
	@Element(required=false)
	private int longitude;
	
	public GameTO() {}
	
	public GameTO(long gameId, GregorianCalendar startDate, GregorianCalendar finishDate,
			String city, int availablePlaces, int availableHints,
			int availableGoals, int currentTeams, int currentUsers,
			int currentMessages, int maxTeams, int maxUserPerTeam,
			int latitude, int longitude) {
		super();
		this.gameId = gameId;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.city = city;
		this.availablePlaces = availablePlaces;
		this.availableHints = availableHints;
		this.availableGoals = availableGoals;
		this.currentTeams = currentTeams;
		this.currentUsers = currentUsers;
		this.currentMessages = currentMessages;
		this.maxTeams = maxTeams;
		this.maxUserPerTeam = maxUserPerTeam;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	public GregorianCalendar getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(GregorianCalendar finishDate) {
		this.finishDate = finishDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAvailablePlaces() {
		return availablePlaces;
	}
	public void setAvailablePlaces(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}
	public int getAvailableHints() {
		return availableHints;
	}
	public void setAvailableHints(int availableHints) {
		this.availableHints = availableHints;
	}
	public int getAvailableGoals() {
		return availableGoals;
	}
	public void setAvailableGoals(int availableGoals) {
		this.availableGoals = availableGoals;
	}
	public int getCurrentTeams() {
		return currentTeams;
	}
	public void setCurrentTeams(int currentTeams) {
		this.currentTeams = currentTeams;
	}
	public int getCurrentUsers() {
		return currentUsers;
	}
	public void setCurrentUsers(int currentUsers) {
		this.currentUsers = currentUsers;
	}
	public int getCurrentMessages() {
		return currentMessages;
	}
	public void setCurrentMessages(int currentMessages) {
		this.currentMessages = currentMessages;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
