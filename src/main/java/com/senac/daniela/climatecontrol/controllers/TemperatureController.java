package com.senac.daniela.climatecontrol.controllers;

import com.senac.daniela.climatecontrol.entities.Temperature;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.services.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/temperature")
public class TemperatureController {

    private final TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping
    public ResponseEntity<List<Temperature>> getAllDailyTemperatures() {
        List<Temperature> temperature = temperatureService.getAllDailyTemperatures();
        return ResponseEntity.ok(temperature);
    }

    @GetMapping("/search/{municipality_id}")
    public ResponseEntity<Temperature> getTemperature(@PathVariable int municipality_id) {
        try {
            Temperature temperature = temperatureService.getTemperatureByMunicipality(municipality_id);
            return new ResponseEntity<>(temperature, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/average/{municipality_id}")
    public ResponseEntity<Temperature> getAverage(@PathVariable int municipality_id) {
        try {
            Temperature temperature = temperatureService.getTemperatureByMunicipality(municipality_id);
            return new ResponseEntity<>(temperature, HttpStatus.OK);
        } catch (MunicipalityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
