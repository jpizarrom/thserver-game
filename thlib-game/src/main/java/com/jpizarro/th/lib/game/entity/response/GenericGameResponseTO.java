package com.jpizarro.th.lib.game.entity.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.jpizarro.th.lib.game.entity.GoalTO;
import com.jpizarro.th.lib.game.entity.HintTO;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("gamestatus")
@Root
public class GenericGameResponseTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7187541164428347769L;
	
	@ElementList(required=false)
	private List<InGameUserInfoTO> inGameUserInfoTOs = new ArrayList<InGameUserInfoTO>();
//	private Users inGameUserInfoTOs;
	
	@ElementList(required=false)
	private List<HintTO> hints = new ArrayList<HintTO>();
	
	@ElementList(required=false)
	private List<HintTO> hideHints = new ArrayList<HintTO>();
	
	@ElementList(required=false)
	private List<HintTO> userSeeHintTOList = new ArrayList<HintTO>();
	
	@ElementList(required=false)
	private List<HintTO> teamSeeHintTOList = new ArrayList<HintTO>();
	
//	@Element(required=false)
//	private GoalTO goal;
	@ElementList(required=false)
	private List<GoalTO> goals = new ArrayList<GoalTO>();
//	private List<MessageTO> myMessages = new ArrayList<MessageTO>();
	
	@Element(required=false)
	private boolean hasFinished = false;	

	public GenericGameResponseTO() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public List<InGameUserInfoTO> getInGameUserInfoTOs() {
//		return inGameUserInfoTOs;
//	}
//
//	public void setInGameUserInfoTOs(List<InGameUserInfoTO> inGameUserInfoTOs) {
//		this.inGameUserInfoTOs = inGameUserInfoTOs;
//	}
//	
//	public InGameUserInfoTO getInGamePlayerInfoTO(String login) {
//		for (InGameUserInfoTO igpiTO:inGameUserInfoTOs) {
//			if (igpiTO.getUsername().equals(login))
//				return igpiTO;
//		}
//		return null;
//	}

	public List<InGameUserInfoTO> getInGameUserInfoTOs() {
		return inGameUserInfoTOs;
	}

	public void setInGameUserInfoTOs(List<InGameUserInfoTO> inGameUserInfoTOs) {
		this.inGameUserInfoTOs = inGameUserInfoTOs;
	}

	public List<HintTO> getHints() {
		return hints;
	}

	public void setHints(List<HintTO> hints) {
		this.hints = hints;
	}

	public List<HintTO> getHideHints() {
		return hideHints;
	}

	public void setHideHints(List<HintTO> hideHints) {
		this.hideHints = hideHints;
	}

	public List<HintTO> getUserSeeHintTOList() {
		return userSeeHintTOList;
	}

	public void setUserSeeHintTOList(List<HintTO> userSeeHintTOList) {
		this.userSeeHintTOList = userSeeHintTOList;
	}

	public List<HintTO> getTeamSeeHintTOList() {
		return teamSeeHintTOList;
	}

	public void setTeamSeeHintTOList(List<HintTO> teamSeeHintTOList) {
		this.teamSeeHintTOList = teamSeeHintTOList;
	}
	
	public List<GoalTO> getGoals() {
		return goals;
	}

	public void setGoals(List<GoalTO> goals) {
		this.goals = goals;
	}

	public boolean isHasFinished() {
		return hasFinished;
	}

	public void setHasFinished(boolean hasFinished) {
		this.hasFinished = hasFinished;
	}

//	public List<MessageTO> getMyMessages() {
//		return myMessages;
//	}
//
//	public void setMyMessages(List<MessageTO> myMessages) {
//		this.myMessages = myMessages;
//	}
}
