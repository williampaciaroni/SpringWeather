package com.example.demo.Models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodayForecast {

	public double temperature;
	
	public int humidity;
	
	public int pressure;
	
	public double cloud;
	
	@JsonProperty("main")
	private void unpackMain(Map<String, Object> main) {
	    temperature = ((Number) main.get("temp")).doubleValue();
	    humidity = ((Number) main.get("humidity")).intValue();
	    pressure = ((Number) main.get("pressure")).intValue();
	}
	
	@JsonProperty("cloud")
	private void unpackCloud(Map<String, Object> cloud) {
	    this.cloud = ((Number) cloud.get("all")).doubleValue();
	}
}
