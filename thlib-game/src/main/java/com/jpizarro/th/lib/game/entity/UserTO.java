package com.jpizarro.th.lib.game.entity;

import java.io.Serializable;

public class UserTO implements Serializable{

	private long userId;

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}
}
