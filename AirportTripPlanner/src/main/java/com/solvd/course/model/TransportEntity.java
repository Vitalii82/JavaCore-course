package com.solvd.course.model;

public abstract class TransportEntity {
    private Airport from;
    private Airport to;

    public TransportEntity(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public Airport getFrom() { return from; }
    public void setFrom(Airport from) { this.from = from; }

    public Airport getTo() { return to; }
    public void setTo(Airport to) { this.to = to; }

    public abstract String getTransportType();
}
