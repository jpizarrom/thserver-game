package com.jpizarro.th.server.game.model.persistence.accessor;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jpizarro.th.lib.game.entity.list.GameCTO;
import com.jpizarro.th.server.game.model.entity.Game;
import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessorHibernate;

public class GameAccessorHibernate 
extends GenericAccessorHibernate<Game, Long> 
implements GameAccessor {

	private static final int LIMIT_GAME_DISTANCE = 2;

	@Override
	public GameCTO findNotFinishedByCity(String city, int startIndex, int count) {
		Calendar currentTime = Calendar.getInstance();
		Criteria criteria = getSession().createCriteria(Game.class);
//		criteria.addOrder(Order.asc("finishDate"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(count + 1);
		criteria.add(Restrictions.le("startDate", currentTime));
		criteria.add(Restrictions.ne("finished", true));
		criteria.add(Restrictions.ilike("city", ("%" + city + "%")));
		List resultList = criteria.list();
		
		boolean hasMore = false;
		if (resultList.size() == count + 1) {
			resultList = resultList.subList(0, resultList.size() - 1);
			hasMore = true;
		}
		return new GameCTO(resultList, hasMore);
	}

	@Override
	public GameCTO findNotFinishedByLocation(int latitude, int longitude,
			int accurate, int startIndex, int count) {
		Calendar currentTime = Calendar.getInstance();

		int accurateParameter = accurate;
		if (accurateParameter == 0)
			accurateParameter = LIMIT_GAME_DISTANCE;
		int latitudeMargin = latitude + accurate;
		int longitudeMargin = longitude + accurate;
		
		Criteria criteria = getSession().createCriteria(Game.class);
		criteria.addOrder(Order.asc("city"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(count);
		criteria.add(Restrictions.le("startDate", currentTime));
		criteria.add(Restrictions.ne("finished", true));
		criteria.add(Restrictions.lt("latitude", latitudeMargin));
		criteria.add(Restrictions.lt("longitude", longitudeMargin));
		List resultList = criteria.list();
		
		boolean hasMore = false;
		if (resultList.size() == count + 1) {
			resultList = resultList.subList(0, resultList.size() - 1);
			hasMore = true;
		}
		return new GameCTO(resultList, hasMore);
	}

	@Override
	public List<String> findCitiesWithGames() {
		Calendar currentTime = Calendar.getInstance();
		currentTime.add(Calendar.HOUR_OF_DAY, 1);
		
		return getSession().createQuery("SELECT DISTINCT g.city FROM Game g " + 
//				"WHERE g.finishDate > :currentTime " + 
				"ORDER BY g.city").list();
	}

	@Override
	public GameCTO findActiveGames(int startIndex, int count) {
		Calendar currentTime = Calendar.getInstance();
		currentTime.add(Calendar.HOUR_OF_DAY, 1);
		
		Criteria criteria = getSession().createCriteria(Game.class);

		criteria.addOrder(Order.asc("city"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(count);
		criteria.add(Restrictions.le("startDate", currentTime));
		criteria.add(Restrictions.ne("finished", new Boolean(true)));
		List resultList = criteria.list();
		boolean hasMore = false;
		if (resultList.size() == count + 1) {
			resultList = resultList.subList(0, resultList.size() - 1);
			hasMore = true;
		}
		return new GameCTO(resultList, hasMore);
	}

	@Override
	public Integer countActiveGames() {
		Calendar currentTime = Calendar.getInstance();
		currentTime.add(Calendar.HOUR_OF_DAY, 1);
		
		Criteria criteria = getSession().createCriteria(Game.class);

		criteria.addOrder(Order.asc("city"));
		criteria.add(Restrictions.le("startDate", currentTime));
		criteria.add(Restrictions.ne("finished", new Boolean(true)));
		return new Integer(criteria.list().size());
	}

	@Override
	public Integer countNotFinishedGames() {
		Criteria criteria = getSession().createCriteria(Game.class);
		criteria.addOrder(Order.asc("city"));
		criteria.add(Restrictions.ne("finished", true));
		return new Integer(criteria.list().size());
	}

	@Override
	public GameCTO findNotFinishedGames(int startIndex, int count) {
		Criteria criteria = getSession().createCriteria(Game.class);
		criteria.addOrder(Order.asc("city"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(count);
		criteria.add(Restrictions.ne("finished", true));
		List resultList = criteria.list();
		
		boolean hasMore = false;
		if (resultList.size() == count + 1) {
			resultList = resultList.subList(0, resultList.size() - 1);
			hasMore = true;
		}
		return new GameCTO(resultList, hasMore);
	}

	@Override
	public GameCTO findFinishedGames(int startIndex, int count) {
		Criteria criteria = getSession().createCriteria(Game.class);
		criteria.addOrder(Order.asc("city"));
		criteria.setFirstResult(startIndex);
		criteria.setMaxResults(count);
		criteria.add(Restrictions.eq("finished", true));
		List resultList = criteria.list();
		
		boolean hasMore = false;
		if (resultList.size() == count + 1) {
			resultList = resultList.subList(0, resultList.size() - 1);
			hasMore = true;
		}
		return new GameCTO(resultList, hasMore);
	}

	@Override
	public Integer countFinishedGames() {
		Criteria criteria = getSession().createCriteria(Game.class);
		criteria.addOrder(Order.asc("city"));
		criteria.add(Restrictions.eq("finished", true));
		return new Integer(criteria.list().size());
	}

}
