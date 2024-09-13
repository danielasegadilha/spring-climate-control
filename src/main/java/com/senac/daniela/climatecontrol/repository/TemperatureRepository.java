package com.senac.daniela.climatecontrol.repository;

import com.senac.daniela.climatecontrol.entities.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
    @Query("SELECT t FROM Temperature t WHERE t.date = CURRENT_DATE")
    List<Temperature> getAllDailyTemperatures();

    @Query("SELECT t FROM Temperature t WHERE t.date = CURRENT_DATE AND t.municipality.id = :id")
    Optional<Temperature> getTemperatureByMunicipality(@Param("id") int id);

    @Query("SELECT AVG(t.value) FROM Temperature t WHERE t.municipality.id = :id AND FUNCTION('MONTH', t.date) = FUNCTION('MONTH', CURRENT_DATE) AND FUNCTION('YEAR', t.date) = FUNCTION('YEAR', CURRENT_DATE)")
    Optional<Double> getAverageTemperatureByMonth(@Param("id") int id);
}