package com.example.geektrust.streaming;

import com.example.geektrust.plan.Plan;
import com.example.geektrust.topup.TopUp;

public class Streaming {
    private Plan plan;
    private static TopUp topUp;

    public Streaming() {
    }

    public Streaming(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(TopUp topUp) {
        Streaming.topUp = topUp;
    }

    public void addTopUp(TopUp topUp) {
        if (Streaming.topUp != null) {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
        setTopUp(topUp);
    }

    @Override
    public String toString() {
        return "Streaming{" +
                "plan=" + plan +
                ", topUp=" + topUp +
                '}';
    }

}
