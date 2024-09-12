package com.senac.daniela.climatecontrol.repository;

import com.senac.daniela.climatecontrol.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {
}
