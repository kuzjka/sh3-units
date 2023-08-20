package ua.kuzjka.sh3.dto;

public class NationEntry {
    private int id;
    private String nation;
    private String flagUrl;

    public NationEntry() {
    }

    public NationEntry(int id, String nation, String flagUrl) {
        this.id = id;
        this.nation = nation;
        this.flagUrl = flagUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
