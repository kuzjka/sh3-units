package ua.kuzjka.sh3.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("M")
@Table(name = "merchants")
public class Merchant extends Ship {
    @Enumerated(EnumType.STRING)
    private MerchantCategory category;

    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY)
    private List<MerchantPresence> presences = new ArrayList<>();

    /**
     * Gets merchant category.
     * @return  Merchant ship category
     */
    public MerchantCategory getCategory() {
        return category;
    }

    /**
     * Sets merchant category.
     * @param category  Merchant ship category
     */
    public void setCategory(MerchantCategory category) {
        this.category = category;
    }

    public List<MerchantPresence> getPresences() {
        return presences;
    }

    public void setPresences(List<MerchantPresence> presences) {
        this.presences = presences;
    }
}
