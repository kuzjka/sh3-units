package ua.kuzjka.sh3.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("A")
public class AircraftPresence extends Presence<Aircraft> {
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Aircraft aircraft;

    @Override
    public Aircraft getUnit() {
        return aircraft;
    }

    @Override
    public void setUnit(Aircraft unit) {
        aircraft = unit;
    }
}
