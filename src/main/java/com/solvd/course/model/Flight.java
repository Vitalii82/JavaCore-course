package com.solvd.course.model;

import com.solvd.course.annotations.EntityInfo;

@EntityInfo(author = "You", description = "Flight record", version = 1)
public record Flight(
    String id,
    String flightNumber,
    double price,
    int duration,
    String from,
    String to
) {}
