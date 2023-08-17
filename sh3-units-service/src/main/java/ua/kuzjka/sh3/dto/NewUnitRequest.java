package ua.kuzjka.sh3.dto;

public class NewUnitRequest<T> {
    T unit;
    byte[] image;

    public T getUnit() {
        return unit;
    }

    public void setUnit(T unit) {
        this.unit = unit;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
