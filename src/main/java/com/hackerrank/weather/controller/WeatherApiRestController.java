package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherApiRestController {

    @Autowired
    WeatherService weatherService;

    @PostMapping("/weather")
    public ResponseEntity<?> addNewWeather(@RequestBody Weather weather){
        return new ResponseEntity(weatherService.addNewWeather(weather), HttpStatus.CREATED);
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getAllWeather(){
        return new ResponseEntity<>(weatherService.getAllWeather(), HttpStatus.OK);
    }

    @GetMapping("/weather/{id}")
    public ResponseEntity<?> getWeatherById(@PathVariable Integer id){
        return weatherService.getWeatherById(id);
    }

    @DeleteMapping("/weather/{id}")
    public ResponseEntity<?> deleteWeatherById(@PathVariable Integer id){
        return weatherService.deleteWeatherById(id);
    }

}
