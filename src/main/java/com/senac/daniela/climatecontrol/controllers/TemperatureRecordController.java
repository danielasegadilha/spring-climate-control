package com.senac.daniela.climatecontrol.controllers;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.services.TemperatureRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/temperature")
public class TemperatureRecordController {

    private final TemperatureRecordService temperatureRecordService;

    public TemperatureRecordController(TemperatureRecordService temperatureRecordService) {
        this.temperatureRecordService = temperatureRecordService;
    }

    @GetMapping
    public ResponseEntity<List<TemperatureRecord>> getAllDailyTemperatures() {
        List<TemperatureRecord> temperatureRecord = temperatureRecordService.getAllDailyTemperatures();
        return ResponseEntity.ok(temperatureRecord);
    }

    @GetMapping("/search/{municipality_id}")
    public ResponseEntity<TemperatureRecord> getTemperature(@PathVariable int weatherStationId) {
        try {
            TemperatureRecord temperatureRecord = temperatureRecordService.getTemperatureByWeatherStation(weatherStationId);
            return new ResponseEntity<>(temperatureRecord, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/average/{municipality_id}")
    public ResponseEntity<Optional<Double>> getAverage(@PathVariable int weatherStationId) {
        try {
            Optional<Double> average = temperatureRecordService.getAverageTemperatureByMonth(weatherStationId);
            return new ResponseEntity<>(average, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
