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
    private Set<Temperature> temperature;

    @Column(name = "municipality_name",nullable = false)
    @Enumerated(EnumType.STRING)
    private MunicipalName name;

    @Column(name = "municipality_region", nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;

    @Column(name = "municipality_area", nullable = false)
    private int area;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(Set<Temperature> temperature) {
        this.temperature = temperature;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

}
