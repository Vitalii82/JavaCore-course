package com.solvd.course.model;

import com.solvd.course.annotations.EntityInfo;

@EntityInfo(version = 1.0, description = "Represents a flight between airports")
public record Flight(String id, String flightNumber, double price, int duration, String from, String to) {
}
