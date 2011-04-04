package com.jpizarro.th.server.game.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn
@DiscriminatorValue("GOA")
public class Goal extends Place {
	
	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goal(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return new String("GOAL " + super.toString());
	}

}
