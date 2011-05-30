package com.jpizarro.th.lib.game.util;


public class GameRestURL {

	public static final String ENTITY = "games";
	
	public static final String ENTITY_ID = "/{id}";
	
//	private static final String LOGIN_URL = "login";
//	private static final String LOGIN_PARAMETER = "login";
//	private static final String CLEAR_PASSWORD_PARAMETER = "password";

	public static final String FIND_CITIES_WITH_GAMES = "/CitiesWithGames";
	
	public static final String FIND_GAMES_BY_CITY = "/GamesByCity/{city}";
	public static final String FIND_GAME_BY_ID = ENTITY_ID;
	public static final String FIND_ACTIVE_GAMES = "/ActiveGames";
	public static final String FIND_FINISHED_GAMES = "/NotFinishedGames";
	public static final String FIND_NOTFINISHED_GAMES = "/FinishedGames";
	
	public static final String COUNT_ACTIVE_GAMES = "/countActiveGames";
	public static final String COUNT_FINISHED_GAMES = "/countFinishedGames";
	public static final String COUNT_NOTFINISHED_GAMES = "/countNotFinishedGames";

//	public static final String CITY_PARAMETER = "city";
//	public static final String START_INDEX_PARAMETER = "startIndex";
//	public static final String COUNT_PARAMETER = "count";
//	public static final String GAME_ID_PARAMETER = "gameId";
//	public static final String TEAM_ID_PARAMETER = "teamId";
//
//	public static final String LOGOUT_URL = "logout";
//
	public static final String START_OR_CONTINUEGAME_URL = "/GameState/{gameId}";
//
//	public static final String UPDATE_LOCATION_URL = "updateLocation";
//	public static final String LATITUDE_PARAMETER = "latitude";
//	public static final String LONGITUDE_PARAMETER = "longitude";
//
//	public static final String SEND_MESSAGE_URL = "sendMessage";
//	public static final String RECEIVER_USER_PARAMETER = "receiverUser";
//	public static final String BODY_PARAMETER = "body";
//
	public static final String FIND_TEAMS_BY_GAME= "/{gameId}/teams";
//	public static final String FIND_TEAM_BY_ID_URL = "findTeamById";
//	public static final String JOIN_GAME_URL = "joinGame";
//
//	public static final String TAKE_PLACE_URL = "takePlace";
//	public static final String PLACE_ID_PARAMETER = "placeId";

}
