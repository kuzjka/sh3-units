package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_sequence")
    @SequenceGenerator(name = "unit_sequence", sequenceName = "unit_sequence")
    private Integer id;

    private String name;
    private int speed;
    private int range;
    private int length;
    private int wingspan;
    private String ordinance;
    private boolean bombs;

    @Column(name = "depth_charges")
    private boolean depthCharges;

    private boolean rockets;
    private boolean torpedoes;

    @Column(name = "pak_gun")
    private boolean pakGun;

    @Column(name = "leigh_light")
    private boolean leighLight;

    private boolean sirene;

    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY)
    private List<AircraftPresence> presences = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets aircraft maximum speed.
     * @return  Max speed in tenths of a knot
     */
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Gets aircraft maximum operating range.
     * @return  Max range in kilometers
     */
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Gets aircraft length.
     * @return  Length in decimeters
     */
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets aircraft wingspan
     * @return  Wingspan in decimeters
     */
    public int getWingspan() {
        return wingspan;
    }

    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    /**
     * Gets types of ordinance.
     * @return  Plane ordinance variants (newline-separated)
     */
    public String getOrdinance() {
        return ordinance;
    }

    public void setOrdinance(String ordinance) {
        this.ordinance = ordinance;
    }

    /**
     * Checks if the aircraft can carry bombs.
     */
    public boolean hasBombs() {
        return bombs;
    }

    public void setBombs(boolean bombs) {
        this.bombs = bombs;
    }

    /**
     * Checks if the aircraft can carry depth charges.
     */
    public boolean hasDepthCharges() {
        return depthCharges;
    }

    public void setDepthCharges(boolean depthCharges) {
        this.depthCharges = depthCharges;
    }

    /**
     * Checks if the aircraft can carry rockets.
     */
    public boolean hasRockets() {
        return rockets;
    }

    public void setRockets(boolean rockets) {
        this.rockets = rockets;
    }

    /**
     * Checks if the aircraft can carry torpedoes.
     */
    public boolean hasTorpedoes() {
        return torpedoes;
    }

    public void setTorpedoes(boolean torpedoes) {
        this.torpedoes = torpedoes;
    }

    /**
     * Checks if the aircraft is equipped with a PAK anti-ship gun.
     */
    public boolean hasPakGun() {
        return pakGun;
    }

    public void setPakGun(boolean pakGun) {
        this.pakGun = pakGun;
    }

    /**
     * Checks if the aircraft is equipped with a Leigh light.
     */
    public boolean hasLeighLight() {
        return leighLight;
    }

    public void setLeighLight(boolean leighLight) {
        this.leighLight = leighLight;
    }

    /**
     * Checks if the aircraft is equipped with sirene.
     */
    public boolean hasSirene() {
        return sirene;
    }

    public void setSirene(boolean sirene) {
        this.sirene = sirene;
    }

    public List<AircraftPresence> getPresences() {
        return presences;
    }

    public void setPresences(List<AircraftPresence> presences) {
        this.presences = presences;
    }
}
