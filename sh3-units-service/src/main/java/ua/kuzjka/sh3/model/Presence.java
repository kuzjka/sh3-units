package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "presences")
public abstract class Presence<T> {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @Column(name = "start_year")
    private int start;

    @Column(name = "end_year")
    private int end;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public abstract T getUnit();

    public abstract void setUnit(T unit);

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    /**
     * Gets the first year when the unit appears for the nation.
     * @return  First year of presence
     */
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /**
     * Gets the last year when the unit appears for the nation.
     * @return  Last year of precense
     */
    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
