package com.example.geektrust.topup;

public class TenDeviceTopUp extends TopUp {
    private int durationInMonths;
    private int cost;

    public TenDeviceTopUp(int durationInMonths, int cost) {
        super(durationInMonths, cost);
    }
}
