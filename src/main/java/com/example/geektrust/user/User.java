package com.example.geektrust.user;

import com.example.geektrust.streaming.Streaming;

import java.util.List;

public class User {
    private List<Streaming> streamingServicesList;

    public User() {
    }

    public User(List<Streaming> streamingServicesList) {
        this.streamingServicesList = streamingServicesList;
    }

    public List<Streaming> getStreamingServicesList() {
        return streamingServicesList;
    }

    public void setStreamingServicesList(List<Streaming> streamingServicesList) {
        this.streamingServicesList = streamingServicesList;
    }

    public void addStreamingPlatform(Streaming streamingService) {
        if (streamingService == null) {
            return;
        }

        for (Streaming streaming : streamingServicesList) {
            if (streamingService.getClass().equals(streaming.getClass())) {
                System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
                return;
            }
        }

        this.streamingServicesList.add(streamingService);
    }

    @Override
    public String toString() {
        return "User{" +
                "streamingServicesList=" + streamingServicesList.toString() +
                '}';
    }


}
