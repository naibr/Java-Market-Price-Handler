package com.nology;

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

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getTimestamp() {
        return timestamp;
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
        double newBid = bid - (bid * 0.001);
        setBid(newBid);
        return newBid;
    }


    public double askMargin(double ask) {
        double newAsk = ask + (ask * 0.001);
        setAsk(newAsk);
        return ask;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", instrumentName='" + instrumentName + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }


}
