package com.senac.daniela.climatecontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "weather_station")
@JsonIgnoreProperties({"temperature"})
public class WeatherStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_station_id", nullable = false)
    private int id;

    @Column(name = "weather_station_status", nullable = false)
    private int status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id")
    private Municipality municipality;

    @OneToMany(mappedBy= "weatherStation")
    private Set<TemperatureRecord> temperatureRecord;
}
