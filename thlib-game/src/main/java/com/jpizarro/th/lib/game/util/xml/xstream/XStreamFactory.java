package com.jpizarro.th.lib.game.util.xml.xstream;

import java.util.List;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.game.entity.GoalTO;
import com.jpizarro.th.lib.game.entity.HintTO;
import com.jpizarro.th.lib.game.entity.list.CitiesTO;
import com.jpizarro.th.lib.game.entity.list.GamesTO;
import com.jpizarro.th.lib.game.entity.response.GenericGameResponseTO;
import com.jpizarro.th.lib.game.entity.response.InGameUserInfoTO;
import com.jpizarro.th.lib.game.entity.response.UpdateLocationResponseTO;
import com.jpizarro.th.lib.generic.util.exception.THException;
import com.jpizarro.th.lib.generic.util.xml.xstream.CalendarConverter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamFactory
{
	public static XStream createXStream()
	{
		XStream xstream = new XStream(new DomDriver());
//		XStream xstream = new XStream(new XppDriver());
		
		xstream.registerConverter(new CalendarConverter(), XStream.PRIORITY_VERY_HIGH);
//		xstream.registerConverter(new JoinedConverter(), XStream.PRIORITY_NORMAL);

//		xstream.alias("list", List.class);
//		xstream.alias("string", String.class);
//		xstream.addImplicitCollection(GamesTO.class, "games", GameTO.class);
//		xstream.addImplicitCollection(TeamsTO.class, "teams", TeamTO.class);
//		xstream.addImplicitCollection(UsersTO.class, "users", UserTO.class);
		
//		xstream.addImplicitCollection(CitiesTO.class, "cities");
		
//		xstream.alias("user", UserTO.class);
//		xstream.alias("game", GameTO.class);
//		xstream.alias("team", TeamTO.class);
//		xstream.alias("goal", GoalTO.class);
//		xstream.alias("hint", HintTO.class);
		
		xstream.alias("joined", Boolean.class);
//		xstream.alias("logout", Boolean.class);
//		xstream.alias("messageSent", Boolean.class);
		
//		xstream.alias("city", String.class);
		
//		xstream.alias("games", GamesTO.class);
//		xstream.alias("teams", TeamsTO.class);
//		xstream.alias("users", UsersTO.class);
//		xstream.alias("cities", CitiesTO.class);
//		xstream.alias("message", MessageTO.class);
		
//		xstream.alias("genericGameResponse", GenericGameResponseTO.class);
//		xstream.alias("updateLocationReponse", UpdateLocationResponseTO.class);
//		
//		xstream.alias("inGameUserInfoTO", InGameUserInfoTO.class);
//		
//		xstream.aliasField("user", InGameUserInfoTO.class, "inGameUserInfoTO");
//		xstream.aliasField("users", GenericGameResponseTO.class, "inGameUserInfoTOs");
//		xstream.aliasField("hints", GenericGameResponseTO.class, "hintTOList");
//		xstream.aliasField("hints", GenericGameResponseTO.class, "userSeeHintTOList");
//		xstream.aliasField("hints", GenericGameResponseTO.class, "teamSeeHintTOList");
//		xstream.aliasField("goal", GenericGameResponseTO.class, "goalTO");
//		xstream.aliasField("hideHints", GenericGameResponseTO.class, "hideHintTOList");
		
//		xstream.aliasField("user", InGameUserInfoTO.class, "inGameUserInfoTOs");
//		xstream.aliasField("users", TeamTO.class, "userTOList");
		
//		xstream.alias("exception", THException.class);
		
		return xstream;
	}

}
