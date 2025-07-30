package com.solvd.course.model;

import com.solvd.course.annotations.EntityInfo;

@EntityInfo(author = "Team", description = "Flight entity", version = 1)
public record Flight(
    String id,
    String flightNumber,
    double price,
    int duration,
    String from,
    String to
) {}