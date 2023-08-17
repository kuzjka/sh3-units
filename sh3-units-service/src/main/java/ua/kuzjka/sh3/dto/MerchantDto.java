package ua.kuzjka.sh3.dto;

import ua.kuzjka.sh3.model.Merchant;
import ua.kuzjka.sh3.model.MerchantCategory;

public class MerchantDto {
    private String name;
    private int displacement;
    private float length;
    private float beam;
    private float draft;
    private float mast;
    private float speed;

    private MerchantCategory category;

    public MerchantDto() {
    }

    public MerchantDto(Merchant merchant) {
        this.name = merchant.getName();
        this.displacement = merchant.getDisplacement();
        this.length = merchant.getLength() / 10f;
        this.beam = merchant.getBeam() / 10f;
        this.draft = merchant.getDraft() / 10f;
        this.mast = merchant.getMast() / 10f;
        this.speed = merchant.getSpeed() / 10f;
        this.category = merchant.getCategory();
    }

    public Merchant createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setName(name);
        merchant.setDisplacement(displacement);
        merchant.setLength(Math.round(length * 10));
        merchant.setBeam(Math.round(beam * 10));
        merchant.setDraft(Math.round(draft * 10));
        merchant.setMast(Math.round(mast * 10));
        merchant.setSpeed(Math.round(speed * 10));
        merchant.setCategory(category);
        return merchant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getBeam() {
        return beam;
    }

    public void setBeam(float beam) {
        this.beam = beam;
    }

    public float getDraft() {
        return draft;
    }

    public void setDraft(float draft) {
        this.draft = draft;
    }

    public float getMast() {
        return mast;
    }

    public void setMast(float mast) {
        this.mast = mast;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public MerchantCategory getCategory() {
        return category;
    }

    public void setCategory(MerchantCategory category) {
        this.category = category;
    }
}
