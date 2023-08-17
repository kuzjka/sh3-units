package ua.kuzjka.sh3.dto;

import ua.kuzjka.sh3.model.Warship;
import ua.kuzjka.sh3.model.WarshipCategory;

public class WarshipDto {
    private String name;
    private int displacement;
    private float length;
    private float beam;
    private float draft;
    private float mast;
    private float speed;
    private WarshipCategory category;
    private boolean deckGun;
    private boolean aaGun;
    private boolean torpedoes;
    private boolean depthCharges;

    public WarshipDto() {
    }

    public WarshipDto(Warship warship) {
        this.name = warship.getName();
        this.displacement = warship.getDisplacement();
        this.length = warship.getLength() / 10f;
        this.beam = warship.getBeam() / 10f;
        this.draft = warship.getDraft() / 10f;
        this.mast = warship.getMast() / 10f;
        this.speed = warship.getSpeed() / 10f;
        this.category = warship.getCategory();
        this.deckGun = warship.hasDeckGun();
        this.aaGun = warship.hasAAGun();
        this.torpedoes = warship.hasTorpedoes();
        this.depthCharges = warship.hasDepthCharges();
    }

    public Warship createWarship() {
        Warship warship = new Warship();
        warship.setName(name);
        warship.setDisplacement(displacement);
        warship.setLength(Math.round(length * 10));
        warship.setBeam(Math.round(beam * 10));
        warship.setDraft(Math.round(draft * 10));
        warship.setMast(Math.round(mast * 10));
        warship.setSpeed(Math.round(speed * 10));
        warship.setCategory(category);
        warship.setDeckGun(deckGun);
        warship.setAAGun(aaGun);
        warship.setTorpedoes(torpedoes);
        warship.setDepthCharges(depthCharges);
        return warship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBeam() {
        return beam;
    }

    public void setBeam(float beam) {
        this.beam = beam;
    }

    public float getDraft() {
        return draft;
    }

    public void setDraft(float draft) {
        this.draft = draft;
    }

    public float getMast() {
        return mast;
    }

    public void setMast(float mast) {
        this.mast = mast;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public WarshipCategory getCategory() {
        return category;
    }

    public void setCategory(WarshipCategory category) {
        this.category = category;
    }

    public boolean isDeckGun() {
        return deckGun;
    }

    public void setDeckGun(boolean deckGun) {
        this.deckGun = deckGun;
    }

    public boolean isAaGun() {
        return aaGun;
    }

    public void setAaGun(boolean aaGun) {
        this.aaGun = aaGun;
    }

    public boolean isTorpedoes() {
        return torpedoes;
    }

    public void setTorpedoes(boolean torpedoes) {
        this.torpedoes = torpedoes;
    }

    public boolean isDepthCharges() {
        return depthCharges;
    }

    public void setDepthCharges(boolean depthCharges) {
        this.depthCharges = depthCharges;
    }
}
