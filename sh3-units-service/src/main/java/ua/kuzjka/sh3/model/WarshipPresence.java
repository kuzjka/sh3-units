package ua.kuzjka.sh3.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("W")
public class WarshipPresence extends Presence<Warship> {
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Warship warship;

    public WarshipPresence() {
    }

    public WarshipPresence(Nation nation, Warship warship, int start, int end) {
        super(nation, start, end);
        this.warship = warship;
    }

    @Override
    public Warship getUnit() {
        return warship;
    }

    @Override
    public void setUnit(Warship unit) {
        warship = unit;
    }
}
