package com.example.koleg.currencymonitor.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "fixerTable")
public class Currency {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Double value;

    @Ignore
    public Currency(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Currency(int id, String name, Double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}