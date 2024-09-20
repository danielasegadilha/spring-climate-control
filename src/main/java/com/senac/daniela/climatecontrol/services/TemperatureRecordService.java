package com.senac.daniela.climatecontrol.services;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.repository.TemperatureRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRecordService {

    private static TemperatureRecordRepository temperatureRecordRepository;

    public TemperatureRecordService(TemperatureRecordRepository temperatureRecordRepository) {
        this.temperatureRecordRepository = temperatureRecordRepository;
    }

    public List<TemperatureRecord> getAllDailyTemperatures() {
        return temperatureRecordRepository.getAllDailyTemperatures();
    }

    public TemperatureRecord getTemperatureByMunicipality(int id) {
        return temperatureRecordRepository.getTemperatureByMunicipality(id).orElseThrow(()-> new MunicipalityNotFoundException("Municipality not found"));
    }

    public Optional<Double> getAverageTemperatureByMonth(int id) {
        return temperatureRecordRepository.getAverageTemperatureByMonth(id).orElseThrow(()-> new MunicipalityNotFoundException("Municipality not found")).describeConstable();
    };
}
