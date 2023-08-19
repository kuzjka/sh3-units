package ua.kuzjka.sh3.dto;

import ua.kuzjka.sh3.model.Aircraft;

public class AircraftDto {
    private String name;
    private int speed;
    private int range;
    private float length;
    private float wingspan;
    private String ordnance;
    private boolean bombs;
    private boolean depthCharges;
    private boolean rockets;
    private boolean torpedoes;
    private boolean pakGun;
    private boolean leighLight;
    private boolean sirene;

    public AircraftDto() {
    }

    public AircraftDto(Aircraft aircraft) {
        this.name = aircraft.getName();
        this.speed = aircraft.getSpeed() / 10;
        this.range = aircraft.getRange();
        this.length = aircraft.getLength() / 10f;
        this.wingspan = aircraft.getWingspan() / 10f;
        this.ordnance = aircraft.getOrdnance();
        this.bombs = aircraft.hasBombs();
        this.depthCharges = aircraft.hasDepthCharges();
        this.rockets = aircraft.hasRockets();
        this.torpedoes = aircraft.hasTorpedoes();
        this.pakGun = aircraft.hasPakGun();
        this.leighLight = aircraft.hasLeighLight();
        this.sirene = aircraft.hasSirene();
    }

    public Aircraft createAircraft() {
        Aircraft aircraft = new Aircraft();
        aircraft.setName(name);
        aircraft.setSpeed(speed * 10);
        aircraft.setRange(range);
        aircraft.setLength(Math.round(length * 10));
        aircraft.setWingspan(Math.round(wingspan * 10));
        aircraft.setOrdnance(ordnance);
        aircraft.setBombs(bombs);
        aircraft.setDepthCharges(depthCharges);
        aircraft.setRockets(rockets);
        aircraft.setTorpedoes(torpedoes);
        aircraft.setPakGun(pakGun);
        aircraft.setLeighLight(leighLight);
        aircraft.setSirene(sirene);
        return aircraft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWingspan() {
        return wingspan;
    }

    public void setWingspan(float wingspan) {
        this.wingspan = wingspan;
    }

    public String getOrdnance() {
        return ordnance;
    }

    public void setOrdnance(String ordnance) {
        this.ordnance = ordnance;
    }

    public boolean isBombs() {
        return bombs;
    }

    public void setBombs(boolean bombs) {
        this.bombs = bombs;
    }

    public boolean isDepthCharges() {
        return depthCharges;
    }

    public void setDepthCharges(boolean depthCharges) {
        this.depthCharges = depthCharges;
    }

    public boolean isRockets() {
        return rockets;
    }

    public void setRockets(boolean rockets) {
        this.rockets = rockets;
    }

    public boolean isTorpedoes() {
        return torpedoes;
    }

    public void setTorpedoes(boolean torpedoes) {
        this.torpedoes = torpedoes;
    }

    public boolean isPakGun() {
        return pakGun;
    }

    public void setPakGun(boolean pakGun) {
        this.pakGun = pakGun;
    }

    public boolean isLeighLight() {
        return leighLight;
    }

    public void setLeighLight(boolean leighLight) {
        this.leighLight = leighLight;
    }

    public boolean isSirene() {
        return sirene;
    }

    public void setSirene(boolean sirene) {
        this.sirene = sirene;
    }
}
