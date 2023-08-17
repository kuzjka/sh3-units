package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("W")
@Table(name = "warships")
public class Warship extends Ship {
    private WarshipCategory category;

    @Column(name = "deck_gun")
    private boolean deckGun;

    @Column(name = "aa_gun")
    private boolean aaGun;

    private boolean torpedoes;

    @Column(name = "depth_charges")
    private boolean depthCharges;

    @OneToMany(mappedBy = "warship", fetch = FetchType.LAZY)
    private List<WarshipPresence> presences = new ArrayList<>();

    /**
     * Gets warship category.
     * @return  Warship category
     */
    public WarshipCategory getCategory() {
        return category;
    }

    /**
     * Sets warship category.
     * @param category  Warship category
     */
    public void setCategory(WarshipCategory category) {
        this.category = category;
    }

    /**
     * Checks if the ship has deck guns (main battery).
     */
    public boolean hasDeckGun() {
        return deckGun;
    }

    public void setDeckGun(boolean deckGun) {
        this.deckGun = deckGun;
    }

    /**
     * Checks if the ship has anti-aircraft battery.
     */
    public boolean hasAAGun() {
        return aaGun;
    }

    public void setAAGun(boolean aaGun) {
        this.aaGun = aaGun;
    }

    /**
     * Checks if the ship carries torpedoes.
     */
    public boolean hasTorpedoes() {
        return torpedoes;
    }

    public void setTorpedoes(boolean torpedoes) {
        this.torpedoes = torpedoes;
    }

    /**
     * Checks if the ship carries depth charge racks.
     */
    public boolean hasDepthCharges() {
        return depthCharges;
    }

    public void setDepthCharges(boolean depthCharges) {
        this.depthCharges = depthCharges;
    }

    public List<WarshipPresence> getPresences() {
        return presences;
    }

    public void setPresences(List<WarshipPresence> presences) {
        this.presences = presences;
    }
}
