package com.nology;

import java.sql.Time;
import java.util.Date;

public class Price {

    private final int id;
    private String instrumentName;
    private double bid;
    private double ask;
    private String timestamp;

    public Price(int id, String instrumentName, double bid, double ask, String timestamp) {
        this.id = id;
        this.instrumentName = instrumentName;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double bidMargin(double bid) {
        this.bid = bid - (bid * 0.001);
        return bid;
    }

    public double askMargin(double ask) {
        this.ask = ask + (ask * 0.001);
        return ask;
    }
}
