package com.example.geektrust.plan;

public class PremiumPlan extends Plan {
    private int durationInMonths;
    private int cost;

    public PremiumPlan(int durationInMonths, int cost) {
        super(durationInMonths, cost);
    }
}
