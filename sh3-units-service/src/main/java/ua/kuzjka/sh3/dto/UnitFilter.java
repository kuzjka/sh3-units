package ua.kuzjka.sh3.dto;

import java.util.List;

public class UnitFilter {
    private Integer year;
    private List<String> nations;

    public UnitFilter() {
    }

    public UnitFilter(Integer year, List<String> nations) {
        this.year = year;
        if (nations != null && nations.isEmpty()) nations = null;
        this.nations = nations;
    }

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
