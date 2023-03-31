package com.hackerrank.weather.service;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherRepository weatherRepository;
    public Weather addNewWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

    @Override
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getWeatherById(Integer id) {
        Optional<Weather> weather = weatherRepository.findById(id);
        if ( weather.isPresent() )
            return new ResponseEntity<>(weather.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Not exists", HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<?> deleteWeatherById(Integer id) {
        Optional<Weather> weather = weatherRepository.findById(id);
        if ( weather.isPresent() ) {
            weatherRepository.delete(weather.get());
            return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>("Not exists", HttpStatus.NOT_FOUND);
    }


}
