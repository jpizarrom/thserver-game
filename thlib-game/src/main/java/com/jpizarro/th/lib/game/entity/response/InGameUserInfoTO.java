package com.jpizarro.th.lib.game.entity.response;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("InGameUserInfoTO")
@Root
public class InGameUserInfoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4241092982460666213L;
	
	@Element(required=false)
	private String username;
	
	@Element(required=false)
	private int latitude;
	
	@Element(required=false)
	private int longitude;
	
	public InGameUserInfoTO() {
		super();
	}
	public InGameUserInfoTO(String username, int latitude, int longitude) {
		super();
		this.username = username;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	

}
