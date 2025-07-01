package com.solvd.course.model;

import com.solvd.course.interfaces.Identifiable;

public abstract class Location implements Identifiable {
    private String code;
    private String name;

    public Location(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public abstract String getLocationType();

    @Override
    public String toString() {
        return getLocationType() + " [" + code + " - " + name + "]";
    }
}
