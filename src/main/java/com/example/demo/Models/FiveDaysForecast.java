package com.example.demo.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiveDaysForecast {

	public List<ThreeHoursElement> nextFiveDaysForecast;
	
	@JsonProperty("list")
	private void getNextFiveDaysForecast(List<ThreeHoursElement> list) {
		nextFiveDaysForecast = list;
	}
	
}
