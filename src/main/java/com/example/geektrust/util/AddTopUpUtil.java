package com.example.geektrust.util;

import com.example.geektrust.streaming.Streaming;
import com.example.geektrust.topup.FourDeviceTopUp;
import com.example.geektrust.topup.TenDeviceTopUp;
import com.example.geektrust.topup.TopUp;
import com.example.geektrust.user.User;

public class AddTopUpUtil {
    private static final String FOUR_DEVICE = "FOUR_DEVICE";
    private static final String TEN_DEVICE = "TEN_DEVICE";

    public void addTopUpType(String topUpType, User user,int numberOfMonths) {
        Streaming streamingPlatform = new Streaming();
        if (user.getStreamingServicesList().size() == 0) {
            System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            return;
        }
        switch (topUpType) {
            case TEN_DEVICE:
                TopUp tenDeviceTopUp = new TenDeviceTopUp(numberOfMonths, 150);
                streamingPlatform.addTopUp(tenDeviceTopUp);
                break;
            case FOUR_DEVICE:
                TopUp fourDeviceTopup = new FourDeviceTopUp(numberOfMonths, 50);
                streamingPlatform.addTopUp(fourDeviceTopup);
                break;
        }
    }
}
