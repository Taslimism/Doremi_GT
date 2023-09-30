package com.example.geektrust.plan;

public class Plan {
    private int durationInMonths;
    private int cost;

    public Plan(int durationInMonths, int cost) {
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
}
