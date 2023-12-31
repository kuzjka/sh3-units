package ua.kuzjka.sh3.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nations")
public class Nation {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
    private List<MerchantPresence> merchants = new ArrayList<>();

    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
    private List<WarshipPresence> warships = new ArrayList<>();

    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
    private List<UBoatPresence> uboats = new ArrayList<>();

    @OneToMany(mappedBy = "nation", fetch = FetchType.LAZY)
    private List<AircraftPresence> aircrafts = new ArrayList<>();

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

    public List<MerchantPresence> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<MerchantPresence> merchants) {
        this.merchants = merchants;
    }

    public List<WarshipPresence> getWarships() {
        return warships;
    }

    public void setWarships(List<WarshipPresence> warships) {
        this.warships = warships;
    }

    public List<UBoatPresence> getUboats() {
        return uboats;
    }

    public void setUboats(List<UBoatPresence> uboats) {
        this.uboats = uboats;
    }

    public List<AircraftPresence> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<AircraftPresence> aircrafts) {
        this.aircrafts = aircrafts;
    }
}
