package com.jpizarro.th.lib.game.entity.list;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.jpizarro.th.lib.game.entity.GameTO;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cities")
@Root
public class CitiesTO {
	private Integer count;
	private Integer start;
	private Integer total;
	@ElementList
	private List<String> cities = new ArrayList<String>();
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
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	private void addCity(String c){
		this.cities.add(c);
	}
}
