package org.example.model;

public enum Type {
    AUTO(46.10, 12.5), //легковой авто
    CARGO(47.50, 12), //грузовой авто
    PASSANGER(48.90, 11.5), //пассажирский транспорт
    HEAVY(48.90, 20); //тяжелая техника

    double fuel;
    double rate;


    Type(double fuel, double rate) {
        this.fuel = fuel;
        this.rate = rate;
    }

    public double getFuel() {
        return fuel;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Type{" +
                "fuel=" + fuel +
                ", rate=" + rate +
                "} " + super.toString();
    }
}
