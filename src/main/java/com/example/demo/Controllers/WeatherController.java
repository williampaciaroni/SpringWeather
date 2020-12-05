package com.example.demo.Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Models.FiveDaysForecast;
import com.example.demo.Models.TodayForecast;
import com.example.demo.Models.Forecast;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class WeatherController {
	
	private String apiKey = "b16e4e1b9773777a6c60de6553079b76";
	@GetMapping("/api/weather")
	@ResponseBody
	public Object getForecast(@RequestParam String city) throws MalformedURLException, IOException { 
	    
		Forecast forecast = new Forecast();
		
		forecast.setCity(city);
		
		forecast.setFiveDaysForecast(getFiveDaysForecast(city).nextFiveDaysForecast);
		
		forecast.setTodayForecast(getTodayForecast(city));
	    
	    try {
			return forecast;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "Error";
		}
	    
	}
	
	public FiveDaysForecast getFiveDaysForecast(String city) throws MalformedURLException, IOException {
		
		String fiveDaysURL = "https://api.openweathermap.org/data/2.5/forecast?q="+city+"&mode=json&appid="+apiKey;
		
	    HttpURLConnection url = (HttpURLConnection) new URL(fiveDaysURL).openConnection();
	    
	    url.setRequestMethod("GET");
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
	    
	    String inputLine;
	    
	    StringBuffer next = new StringBuffer();
	    
	    while ((inputLine = in.readLine()) != null) {
	    	next.append(inputLine);
	    }
	    
	    in.close();
	    
	    url.disconnect();
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    
	    FiveDaysForecast fv = objectMapper.readValue(next.toString(), FiveDaysForecast.class);
	    
		return fv; 
	}
	
	public TodayForecast getTodayForecast(String city) throws MalformedURLException, IOException {
		
		String todayURL = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey;
		
	    HttpURLConnection url = (HttpURLConnection) new URL(todayURL).openConnection();
	    
	    url.setRequestMethod("GET");
	    
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
	    
	    String inputLine;
	    
	    StringBuffer next = new StringBuffer();
	    
	    while ((inputLine = in.readLine()) != null) {
	    	next.append(inputLine);
	    }
	    
	    in.close();
	    
	    url.disconnect();
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    
	    TodayForecast tf = objectMapper.readValue(next.toString(), TodayForecast.class);
	    
		return tf; 
	}

}
