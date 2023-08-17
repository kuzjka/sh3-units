package ua.kuzjka.sh3.dto;

import java.util.List;

public class OrderOfBattleDto {
    private int nationId;

    private List<PresenceDto> merchants;
    private List<PresenceDto> warships;
    private List<PresenceDto> uboats;
    private List<PresenceDto> aircraft;

    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    public List<PresenceDto> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<PresenceDto> merchants) {
        this.merchants = merchants;
    }

    public List<PresenceDto> getWarships() {
        return warships;
    }

    public void setWarships(List<PresenceDto> warships) {
        this.warships = warships;
    }

    public List<PresenceDto> getUboats() {
        return uboats;
    }

    public void setUboats(List<PresenceDto> uboats) {
        this.uboats = uboats;
    }

    public List<PresenceDto> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<PresenceDto> aircraft) {
        this.aircraft = aircraft;
    }
}
