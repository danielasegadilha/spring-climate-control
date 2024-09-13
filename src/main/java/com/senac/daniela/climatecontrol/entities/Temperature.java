package com.senac.daniela.climatecontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "temperature")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temperature_id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id")
    private Municipality municipality;

    @Column(name = "temperature_data", nullable = false)
    private LocalDate data;

    @Column(name = "temperature_value", nullable = false)
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
