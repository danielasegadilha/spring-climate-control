package com.senac.daniela.climatecontrol.services;

import com.senac.daniela.climatecontrol.entities.Temperature;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.repository.TemperatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureService {

    private static TemperatureRepository temperatureRepository;

    public TemperatureService(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public List<Temperature> getAllDailyTemperatures() {
        return temperatureRepository.getAllDailyTemperatures();
    }

    public Temperature getTemperatureByMunicipality(int id) {
        return temperatureRepository.getTemperatureByMunicipality(id).orElseThrow(()-> new MunicipalityNotFoundException("Municipality not found"));
    }

    public Optional<Double> getAverageTemperatureByMonth(int id) {
        return temperatureRepository.getAverageTemperatureByMonth(id).orElseThrow(()-> new MunicipalityNotFoundException("Municipality not found")).describeConstable();
    };
}
