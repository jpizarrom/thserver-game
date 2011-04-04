package com.jpizarro.th.server.game.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.jpizarro.th.lib.place.entity.PlaceTO;

@Entity
@PrimaryKeyJoinColumn
@DiscriminatorValue("HIN")
public class Hint extends Place{

	public Hint() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hint(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return new String("HINT " + super.toString());
	}
}
