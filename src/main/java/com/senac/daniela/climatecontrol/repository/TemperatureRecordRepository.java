package com.senac.daniela.climatecontrol.repository;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRecordRepository extends JpaRepository<TemperatureRecord, Long> {
    @Query("SELECT AVG(t.value) FROM TemperatureRecord t " +
            "JOIN t.weatherStation ws " +
            "JOIN ws.municipality m " +
            "WHERE m.id = :municipalityId AND t.date = CURRENT_DATE")
    Optional<Double> getDailyAverageTemperatureByMunicipalityId(@Param("municipalityId") int municipalityId);

    @Query("SELECT t FROM TemperatureRecord t " +
            "JOIN t.weatherStation ws " +
            "JOIN ws.municipality m " +
            "WHERE m.id = :municipalityId AND t.date = :date")
    List<TemperatureRecord> getAllDailyTemperaturesByMunicipalityId(@Param("municipalityId") int municipalityId, @Param("date") LocalDate date);

    @Query("SELECT AVG(t.value) FROM TemperatureRecord t " +
            "JOIN t.weatherStation ws " +
            "JOIN ws.municipality m " +
            "WHERE m.id = :municipalityId " +
            "AND FUNCTION('MONTH', t.date) = FUNCTION('MONTH', :date) " +
            "AND FUNCTION('YEAR', t.date) = FUNCTION('YEAR', :date)")
    Optional<Double> getAverageTemperatureByMonth(@Param("municipalityId") int municipalityId, @Param("date") LocalDate date);
}