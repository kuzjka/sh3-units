package ua.kuzjka.sh3.dto;

import java.util.List;

public class UnitFilter {
    private Integer year;
    private List<String> nations;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getNations() {
        return nations;
    }

    public void setNations(List<String> nations) {
        this.nations = nations;
    }
}
