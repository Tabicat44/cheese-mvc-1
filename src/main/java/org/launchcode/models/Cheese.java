package org.launchcode.models;

import jdk.jfr.events.CertificateId;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GenerateValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by LaunchCode
 */

@Entity

public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

//    private CheeseType type;
    private CheeseType type = CheeseType.HARD;
/*
    private int cheeseId;
    private static int nextId = 1;*/

    public Cheese(String name, String description) {
/*        this();*/
        this.name = name;
        this.description = description;
    }
    public Cheese(){}

/*    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }*/

/*

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }*/

    public int getId(){ return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
