package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "uboats")
public class UBoat {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(name = "displ_surf")
    private int displacementSurfaced;

    @Column(name = "displ_subm")
    private int displacementSubmerged;

    @Column(name = "speed_surf")
    private int speedSurfaced;

    @Column(name = "speed_subm")
    private int speedSubmerged;

    @Column(name = "diving_depth")
    private int divingDepth;

    @Column(name = "bow_tubes")
    private int bowTubes;

    @Column(name = "stern_tubes")
    private int sternTubes;

    @OneToMany(mappedBy = "uboat", fetch = FetchType.LAZY)
    private List<UBoatPresence> presences;

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
     * Gets boat displacement when surfaced.
     * @return  Boat displacement in tons
     */
    public int getDisplacementSurfaced() {
        return displacementSurfaced;
    }

    public void setDisplacementSurfaced(int displacementSurfaced) {
        this.displacementSurfaced = displacementSurfaced;
    }

    /**
     * Gets boat displacement when submerged.
     * @return  Boat displacement in tons
     */
    public int getDisplacementSubmerged() {
        return displacementSubmerged;
    }

    public void setDisplacementSubmerged(int displacementSubmerged) {
        this.displacementSubmerged = displacementSubmerged;
    }

    /**
     * Gets max speed on surface.
     * @return  Boat speed in tenths of a knot
     */
    public int getSpeedSurfaced() {
        return speedSurfaced;
    }

    public void setSpeedSurfaced(int speedSurfaced) {
        this.speedSurfaced = speedSurfaced;
    }

    /**
     * Gets max speed when submerged.
     * @return  Boat speed in tenths of a knot
     */
    public int getSpeedSubmerged() {
        return speedSubmerged;
    }

    public void setSpeedSubmerged(int speedSubmerged) {
        this.speedSubmerged = speedSubmerged;
    }

    /**
     * Gets max boat diving depth.
     * @return  Diving depth in meters
     */
    public int getDivingDepth() {
        return divingDepth;
    }

    public void setDivingDepth(int divingDepth) {
        this.divingDepth = divingDepth;
    }

    /**
     * Gets the number of bow tubes.
     * @return  Number of bow tubes
     */
    public int getBowTubes() {
        return bowTubes;
    }

    public void setBowTubes(int bowTubes) {
        this.bowTubes = bowTubes;
    }

    /**
     * Gets the number of stern tubes.
     * @return  Number of stern tubes
     */
    public int getSternTubes() {
        return sternTubes;
    }

    public void setSternTubes(int sternTubes) {
        this.sternTubes = sternTubes;
    }

    public List<UBoatPresence> getPresences() {
        return presences;
    }

    public void setPresences(List<UBoatPresence> presences) {
        this.presences = presences;
    }
}
