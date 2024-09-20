package com.senac.daniela.climatecontrol.repository;

import com.senac.daniela.climatecontrol.entities.TemperatureRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRecordRepository extends JpaRepository<TemperatureRecord, Long> {
    @Query("SELECT t FROM Temperature t WHERE t.date = CURRENT_DATE")
    List<TemperatureRecord> getAllDailyTemperatures();

    @Query("SELECT t FROM Temperature t WHERE t.date = CURRENT_DATE AND t.municipality.id = :id")
    Optional<TemperatureRecord> getTemperatureByMunicipality(@Param("id") int id);

    @Query("""
        SELECT AVG(dailyAvg) FROM (SELECT AVG(t.value) AS dailyAvg FROM Temperature t WHERE t.municipality.id = :id AND FUNCTION('MONTH', t.date) = FUNCTION('MONTH', CURRENT_DATE) AND FUNCTION('YEAR', t.date) = FUNCTION('YEAR', CURRENT_DATE)GROUP BY FUNCTION('DAY', t.date)) AS dailyAverages""")
    Optional<Double> getAverageTemperatureByMonth(@Param("id") int id);
}