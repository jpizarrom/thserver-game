package com.jpizarro.th.server.game.model.persistence.accessor;

import java.util.List;

import com.jpizarro.th.lib.game.entity.list.GameCTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessor;

public interface GameAccessor extends GenericAccessor<Game, Long> {
	public GameCTO findNotFinishedByCity(String city, 
			int startIndex, int count);
	
	public GameCTO findNotFinishedByLocation(int latitude, int longitude, 
			int accurate, int startIndex, int count);
	
	public List<String> findCitiesWithGames();
	
	public GameCTO findActiveGames(int startIndex, int count);
	
	public Integer countActiveGames();
	
	public Integer countNotFinishedGames();
	
	public GameCTO findNotFinishedGames(int startIndex, int count);
	
	public GameCTO findFinishedGames(int startIndex, int count);
	
	public Integer countFinishedGames();
}
