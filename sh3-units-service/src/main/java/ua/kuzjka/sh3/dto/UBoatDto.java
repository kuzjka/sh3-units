package ua.kuzjka.sh3.dto;

import ua.kuzjka.sh3.model.UBoat;

public class UBoatDto {
    private String name;
    private int displacementSurfaced;
    private int displacementSubmerged;
    private float speedSurfaced;
    private float speedSubmerged;
    private int divingDepth;
    private int bowTubes;
    private int sternTubes;

    public UBoatDto() {
    }

    public UBoatDto(UBoat uBoat) {
        this.name = uBoat.getName();
        this.displacementSurfaced = uBoat.getDisplacementSurfaced();
        this.displacementSubmerged = uBoat.getDisplacementSubmerged();
        this.speedSurfaced = uBoat.getSpeedSurfaced() / 10f;
        this.speedSubmerged = uBoat.getSpeedSubmerged() / 10f;
        this.divingDepth = uBoat.getDivingDepth();
        this.bowTubes = uBoat.getBowTubes();
        this.sternTubes = uBoat.getSternTubes();
    }

    public UBoat createUBoat() {
        UBoat uBoat = new UBoat();
        uBoat.setName(name);
        uBoat.setDisplacementSurfaced(displacementSurfaced);
        uBoat.setDisplacementSubmerged(displacementSubmerged);
        uBoat.setSpeedSurfaced(Math.round(speedSurfaced * 10));
        uBoat.setSpeedSubmerged(Math.round(speedSubmerged * 10));
        uBoat.setDivingDepth(divingDepth);
        uBoat.setBowTubes(bowTubes);
        uBoat.setSternTubes(sternTubes);
        return uBoat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplacementSurfaced() {
        return displacementSurfaced;
    }

    public void setDisplacementSurfaced(int displacementSurfaced) {
        this.displacementSurfaced = displacementSurfaced;
    }

    public int getDisplacementSubmerged() {
        return displacementSubmerged;
    }

    public void setDisplacementSubmerged(int displacementSubmerged) {
        this.displacementSubmerged = displacementSubmerged;
    }

    public float getSpeedSurfaced() {
        return speedSurfaced;
    }

    public void setSpeedSurfaced(float speedSurfaced) {
        this.speedSurfaced = speedSurfaced;
    }

    public float getSpeedSubmerged() {
        return speedSubmerged;
    }

    public void setSpeedSubmerged(float speedSubmerged) {
        this.speedSubmerged = speedSubmerged;
    }

    public int getDivingDepth() {
        return divingDepth;
    }

    public void setDivingDepth(int divingDepth) {
        this.divingDepth = divingDepth;
    }

    public int getBowTubes() {
        return bowTubes;
    }

    public void setBowTubes(int bowTubes) {
        this.bowTubes = bowTubes;
    }

    public int getSternTubes() {
        return sternTubes;
    }

    public void setSternTubes(int sternTubes) {
        this.sternTubes = sternTubes;
    }
}
