package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WeatherService {

    Weather addNewWeather(Weather weather);

    List<Weather> getAllWeather();

    ResponseEntity<?> getWeatherById(Integer id);

    ResponseEntity<?> deleteWeatherById(Integer id);
}
