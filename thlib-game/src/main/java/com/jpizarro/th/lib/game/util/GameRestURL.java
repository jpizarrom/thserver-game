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

//	private static final String CITY_PARAMETER = "city";
//	private static final String START_INDEX_PARAMETER = "startIndex";
//	private static final String COUNT_PARAMETER = "count";
//	private static final String GAME_ID_PARAMETER = "gameId";
//	private static final String TEAM_ID_PARAMETER = "teamId";
//
//	private static final String LOGOUT_URL = "logout";
//
//	private static final String START_OR_CONTINUEGAME_URL = "GameState";
//
//	private static final String UPDATE_LOCATION_URL = "updateLocation";
//	private static final String LATITUDE_PARAMETER = "latitude";
//	private static final String LONGITUDE_PARAMETER = "longitude";
//
//	private static final String SEND_MESSAGE_URL = "sendMessage";
//	private static final String RECEIVER_USER_PARAMETER = "receiverUser";
//	private static final String BODY_PARAMETER = "body";
//
	public static final String FIND_TEAMS_BY_GAME= "/{gameId}/teams";
//	private static final String FIND_TEAM_BY_ID_URL = "findTeamById";
//	private static final String JOIN_GAME_URL = "joinGame";
//
//	private static final String TAKE_PLACE_URL = "takePlace";
//	private static final String PLACE_ID_PARAMETER = "placeId";

}
