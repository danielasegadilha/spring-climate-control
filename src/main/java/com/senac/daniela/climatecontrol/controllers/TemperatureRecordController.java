package com.senac.daniela.climatecontrol.controllers;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.services.TemperatureRecordService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/temperature")
public class TemperatureRecordController {

    private final TemperatureRecordService temperatureRecordService;

    public TemperatureRecordController(TemperatureRecordService temperatureRecordService) {
        this.temperatureRecordService = temperatureRecordService;
    }

    @GetMapping("/current-date/{municipality_id}")
    public ResponseEntity<Optional<Double>> getAllDailyTemperatures(@PathVariable("municipality_id") int municipalityId) {
        try {
            Optional<Double> average = temperatureRecordService.getAverageTemperatureByMunicipality(municipalityId);
            return new ResponseEntity<>(average, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/daily-average/{municipality_id}/{date}")
    public ResponseEntity<List<TemperatureRecord>> getTemperature(@PathVariable("municipality_id") int municipalityId, @PathVariable LocalDate date) {
        List<TemperatureRecord> temperatureRecord = temperatureRecordService.getDailyAverageTemperatureByMunicipality(municipalityId, date);
        return ResponseEntity.ok(temperatureRecord);
    }

    @GetMapping("/month-average/{municipality_id}/{date}")
    public ResponseEntity<Optional<Double>> getAverage(@PathVariable("municipality_id") int municipalityId, @PathVariable LocalDate date) {
        try {
            Optional<Double> average = temperatureRecordService.getAverageTemperatureByMonth(municipalityId, date);
            return new ResponseEntity<>(average, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
