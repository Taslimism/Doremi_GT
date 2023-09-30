package com.example.geektrust.topup;

import com.example.geektrust.streaming.Streaming;

public class TopUp {
    private int durationInMonths;
    private int cost;

    public TopUp(int durationInMonths, int cost) {
        this.durationInMonths = durationInMonths;
        this.cost = cost;
    }
    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TopUp{" +
                "durationInMonths=" + durationInMonths +
                ", cost=" + cost +
                '}';
    }
}
