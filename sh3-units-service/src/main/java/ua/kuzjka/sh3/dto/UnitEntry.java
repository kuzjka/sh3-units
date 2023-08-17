package ua.kuzjka.sh3.dto;

public class UnitEntry<T> {
    private T unit;
    private String imageUrl;
    private String thumbUrl;

    public UnitEntry() {
    }

    public UnitEntry(T unit, String imageUrl, String thumbUrl) {
        this.unit = unit;
        this.imageUrl = imageUrl;
        this.thumbUrl = thumbUrl;
    }

    public T getUnit() {
        return unit;
    }

    public void setUnit(T unit) {
        this.unit = unit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
