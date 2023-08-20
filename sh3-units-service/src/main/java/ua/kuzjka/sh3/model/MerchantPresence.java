package ua.kuzjka.sh3.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("M")
public class MerchantPresence extends Presence<Merchant> {
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Merchant merchant;

    public MerchantPresence() {
    }

    public MerchantPresence(Nation nation, Merchant merchant, int start, int end) {
        super(nation, start, end);
        this.merchant = merchant;
    }

    @Override
    public Merchant getUnit() {
        return merchant;
    }

    @Override
    public void setUnit(Merchant unit) {
        merchant = unit;
    }
}
