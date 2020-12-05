package com.example.demo.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Forecast {
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("TodayForecast")
	private TodayForecast todayForecast;
	
	@JsonProperty("NextFiveDaysForecast")
	private List<ThreeHoursElement> fiveDaysForecast;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public TodayForecast getTodayForecast() {
		return todayForecast;
	}

	public void setTodayForecast(TodayForecast todayForecast) {
		this.todayForecast = todayForecast;
	}

	public List<ThreeHoursElement> getFiveDaysForecast() {
		return fiveDaysForecast;
	}

	public void setFiveDaysForecast(List<ThreeHoursElement> fiveDaysForecast) {
		this.fiveDaysForecast = fiveDaysForecast;
	}
	
	
}
