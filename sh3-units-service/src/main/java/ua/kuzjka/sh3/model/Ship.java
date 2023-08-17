package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_sequence")
    @SequenceGenerator(name = "unit_sequence", sequenceName = "unit_sequence")
    private Integer id;

    private String name;
    private int displacement;
    private int length;
    private int beam;
    private int draft;
    private int mast;
    private int speed;

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
     * Gets ship displacement.
     * @return  Displacement in tons
     */
    public int getDisplacement() {
        return displacement;
    }

    /**
     * Sets ship displacement.
     * @param displacement  Displacement in tons
     */
    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    /**
     * Gets ship length.
     * @return  Ship length in decimeters
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets ship length.
     * @param length    Ship length in decimeters
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets ship beam (width).
     * @return  Ship beam in decimeters
     */
    public int getBeam() {
        return beam;
    }

    /**
     * Sets ship beam (width).
     * @param beam  Ship beam in decimeters
     */
    public void setBeam(int beam) {
        this.beam = beam;
    }

    /**
     * Gets ship draft (distance from waterline to the bottom of the hull).
     * @return  Ship draft in decimeters
     */
    public int getDraft() {
        return draft;
    }

    /**
     * Sets ship draft (distance from waterline to the bottom of the hull).
     * @param draft Ship draft in decimeters
     */
    public void setDraft(int draft) {
        this.draft = draft;
    }

    /**
     * Gets ship mast height.
     * @return  Mast height in decimeters
     */
    public int getMast() {
        return mast;
    }

    /**
     * Sets ship mast height.
     * @param mast  SHip mast height in decimeters
     */
    public void setMast(int mast) {
        this.mast = mast;
    }

    /**
     * Gets ship max speed.
     * @return  Ship max speed in tenths of a knot (i.e. 70 is 7 knots)
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets ship max speed.
     * @param speed Ship max speed in tenths of a knot (i.e. 70 is 7 knots)
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
