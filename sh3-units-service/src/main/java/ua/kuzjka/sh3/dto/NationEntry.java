package ua.kuzjka.sh3.dto;

public class NationEntry {
    private String nation;
    private String flagUrl;

    public NationEntry() {
    }

    public NationEntry(String nation, String flagUrl) {
        this.nation = nation;
        this.flagUrl = flagUrl;
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
