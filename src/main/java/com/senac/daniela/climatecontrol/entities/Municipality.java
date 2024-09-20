package com.senac.daniela.climatecontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.senac.daniela.climatecontrol.enums.MunicipalName;
import com.senac.daniela.climatecontrol.enums.Region;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "municipality")
@JsonIgnoreProperties({"temperature"})
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "municipality_id", nullable = false)
    private int id;

    @OneToMany(mappedBy= "municipality")
    private Set<WeatherStation> weatherStation;

    @Column(name = "municipality_name",nullable = false)
    @Enumerated(EnumType.STRING)
    private MunicipalName name;

    @Column(name = "municipality_region", nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(name = "municipality_status", nullable = false)
    private int status;

    @Column(name = "municipality_area", nullable = false)
    private int area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<WeatherStation> getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(Set<WeatherStation> weatherStation) {
        this.weatherStation = weatherStation;
    }

    public MunicipalName getName() {
        return name;
    }

    public void setName(MunicipalName name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

}
