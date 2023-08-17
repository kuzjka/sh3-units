package ua.kuzjka.sh3.dto;

public class UnitSelectionEntry {
    private int id;
    private String name;
    private String thumbUrl;

    public UnitSelectionEntry() {
    }

    public UnitSelectionEntry(int id, String name, String thumbUrl) {
        this.id = id;
        this.name = name;
        this.thumbUrl = thumbUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
