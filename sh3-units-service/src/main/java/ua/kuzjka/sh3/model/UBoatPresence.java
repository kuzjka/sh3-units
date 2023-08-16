package ua.kuzjka.sh3.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("U")
public class UBoatPresence extends Presence<UBoat> {
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UBoat uboat;

    @Override
    public UBoat getUnit() {
        return uboat;
    }

    @Override
    public void setUnit(UBoat unit) {
        uboat = unit;
    }
}
