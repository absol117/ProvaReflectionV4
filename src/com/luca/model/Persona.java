package com.luca.model;

import java.io.Serializable;

public class Persona implements Serializable {

    private String name;
    private int eta;

    public Persona(String name, int eta) {
        this.name = name;
        this.eta = eta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", eta=" + eta +
                '}';
    }
}
