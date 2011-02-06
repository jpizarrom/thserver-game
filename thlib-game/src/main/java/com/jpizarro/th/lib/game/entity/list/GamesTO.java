package com.jpizarro.th.lib.game.entity.list;

import java.util.ArrayList;
import java.util.List;

import com.jpizarro.th.lib.game.entity.GameTO;

public class GamesTO {
	private Integer count;
	private Integer start;
	private Integer total;
	private List<GameTO> games;
	private boolean hasMore;
	
	public GamesTO() {
		super();
		// TODO Auto-generated constructor stub
		games = new ArrayList<GameTO>();
	}
	public GamesTO(List<GameTO> gameTOList, boolean hasMore2) {
		// TODO Auto-generated constructor stub
		this.games = gameTOList;
		this.hasMore = hasMore2;
	}
//	public GameTO(Game game) {
//		this.gameId = game.getGameId();
//		this.setName(game.getName());
//		this.setDescription(game.getDescription());
//		this.startDate = game.getStartDate();
//		this.finishDate = game.getFinishDate();
//		this.city = game.getCity();
////		this.pointsToWin = game.getPointsToWin();
//		int pP = 0, hP = 0, gP = 0;
//		for (Place place:game.getPlaces()){
//			pP ++;
//			if (place.getType().equals("HIN"))
//				hP++;
//			if (place.getType().equals("GOA"))
//				gP++;
//		}
//		this.availablePlaces = pP;
//		this.availableHints = hP;
//		this.availableGoals = gP;
//		
//		this.currentTeams = game.getTeams().size();
//		pP = 0;
//		for (Team team:game.getTeams()){
//			pP += team.getUsers().size();
//		}
//		this.currentUsers = pP;
//		this.currentMessages = game.getMessages().size();
//		
//		this.maxTeams = game.getMaxTeams();
//		this.maxUserPerTeam = game.getMaxUserPerTeam();
//		
//		this.latitude = game.getLatitude();
//		this.longitude = game.getLongitude();
//		
//	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<GameTO> getGames() {
		return games;
	}
	public void setGames(List<GameTO> games) {
		this.games = games;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	
}
