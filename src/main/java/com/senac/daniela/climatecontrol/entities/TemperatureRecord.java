package com.senac.daniela.climatecontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "temperature")
public class TemperatureRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temperature_id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_station_id", referencedColumnName = "weather_station_id")
    private WeatherStation weatherStation;

    @Column(name = "temperature_data", nullable = false)
    private LocalDate date;

    @Column(name = "temperature_value", nullable = false)
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeatherStation getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getData() {
        return date;
    }

    public void setData(LocalDate data) {
        this.date = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
