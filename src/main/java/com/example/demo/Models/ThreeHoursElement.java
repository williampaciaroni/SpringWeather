package com.example.demo.Models;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ThreeHoursElement {
	@JsonProperty(value="dt_txt")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date date;
	
	public double temperature;
	
	public int humidity;
	
	public int pressure;
	
	@JsonProperty("main")
	private void unpackMain(Map<String, Object> main) {
	    temperature = ((Number) main.get("temp")).doubleValue();
	    humidity = ((Number) main.get("humidity")).intValue();
	    pressure = ((Number) main.get("pressure")).intValue();
	}

}
