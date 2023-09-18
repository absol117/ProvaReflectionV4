package com.luca.model;

public class Modello extends Persona{
    private int guadagno;

    public Modello(String name, int eta, int guadagno) {
        super(name, eta);
        this.guadagno = guadagno;
    }

    public int getGuadagno() {
        return guadagno;
    }

    public void setGuadagno(int guadagno) {
        this.guadagno = guadagno;
    }

    @Override
    public String toString() {
        return "Modello{" + "name: " + super.getName() + " età: " + super.getEta() +
                " guadagno: " + guadagno +
                '}';
    }
}
