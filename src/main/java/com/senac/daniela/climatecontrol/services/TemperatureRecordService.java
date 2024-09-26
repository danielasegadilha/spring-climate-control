package com.senac.daniela.climatecontrol.services;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import com.senac.daniela.climatecontrol.exceptions.MunicipalityNotFoundException;
import com.senac.daniela.climatecontrol.repository.TemperatureRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureRecordService {

    private static TemperatureRecordRepository temperatureRecordRepository;

    public TemperatureRecordService(TemperatureRecordRepository temperatureRecordRepository) {
        this.temperatureRecordRepository = temperatureRecordRepository;
    }

    public List<TemperatureRecord> getDailyAverageTemperatureByMunicipality(int id, LocalDate date) {
        return temperatureRecordRepository.getAllDailyTemperaturesByMunicipalityId(id, date);
    }

    public Optional<Double> getAverageTemperatureByMunicipality(int id) {
        return temperatureRecordRepository.getDailyAverageTemperatureByMunicipalityId(id);
    }

    public Optional<Double> getAverageTemperatureByMonth(int id, LocalDate date) {
        return temperatureRecordRepository.getAverageTemperatureByMonth(id, date).orElseThrow(()-> new MunicipalityNotFoundException("Municipality not found")).describeConstable();
    };
}
