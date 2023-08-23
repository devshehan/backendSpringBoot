package com.shehaan.backendSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID personID;
    private final String personName;

    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name){
        this.personID = id;
        this.personName = name;
    }

    //getters
    public UUID getPersonID(){
        return personID;
    }
    public String getPersonName(){
        return personName;
    }
}
