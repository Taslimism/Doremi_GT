package com.example.geektrust.util;

import com.example.geektrust.plan.FreePlan;
import com.example.geektrust.plan.PersonalPlan;
import com.example.geektrust.plan.Plan;
import com.example.geektrust.plan.PremiumPlan;
import com.example.geektrust.streaming.MusicStreaming;
import com.example.geektrust.streaming.PodcastStreaming;
import com.example.geektrust.streaming.VideoStreaming;

public class AddSubscriptionUtil {
    private static final String FREE = "FREE";
    private static final String PERSONAL = "PERSONAL";
    private static final String PREMIUM = "PREMIUM";
    private static final int DURATION_IN_MONTHS_FREE_PLAN = 1;
    private static final int DURATION_IN_MONTHS_PERSONAL_PLAN = 1;
    private static final int DURATION_IN_MONTHS_PREMIUM_PLAN = 3;
    private static final int FREE_PLAN_COST = 0;
    private static final int MUSIC_STREAM_PERSONAL_PLAN_COST = 100;
    private static final int MUSIC_STREAM_PREMIUM_PLAN_COST = 250;
    private static final int VIDEO_STREAM_PERSONAL_PLAN_COST = 200;
    private static final int VIDEO_STREAM_PREMIUM_PLAN_COST = 500;
    private static final int PODCAST_STREAM_PERSONAL_PLAN_COST = 0;
    private static final int PODCAST_STREAM_PREMIUM_PLAN_COST = 0;

    public MusicStreaming addPlanForMusicStreaming(String planType) {
        MusicStreaming musicStreaming = null;
        switch (planType) {
            case FREE:
                Plan freePlan = new FreePlan(DURATION_IN_MONTHS_FREE_PLAN, FREE_PLAN_COST);
                musicStreaming = new MusicStreaming(freePlan);
                break;
            case PERSONAL:
                Plan personalPlan = new PersonalPlan(DURATION_IN_MONTHS_PERSONAL_PLAN, MUSIC_STREAM_PERSONAL_PLAN_COST);
                musicStreaming = new MusicStreaming(personalPlan);
                break;
            case PREMIUM:
                Plan premiumPlan = new PremiumPlan(DURATION_IN_MONTHS_PREMIUM_PLAN, MUSIC_STREAM_PREMIUM_PLAN_COST);
                musicStreaming = new MusicStreaming(premiumPlan);
                break;

        }
        return musicStreaming;

    }

    public VideoStreaming addPlanForVideoStreaming(String planType) {
        VideoStreaming videoStreaming = null;
        switch (planType) {
            case FREE:
                Plan freePlan = new FreePlan(DURATION_IN_MONTHS_FREE_PLAN, FREE_PLAN_COST);
                videoStreaming = new VideoStreaming(freePlan);
                break;
            case PREMIUM:
                Plan premiumPlan = new PremiumPlan(DURATION_IN_MONTHS_PREMIUM_PLAN, VIDEO_STREAM_PREMIUM_PLAN_COST);
                videoStreaming = new VideoStreaming(premiumPlan);
                break;
            case PERSONAL:
                Plan personalPlan = new PersonalPlan(DURATION_IN_MONTHS_PERSONAL_PLAN, VIDEO_STREAM_PERSONAL_PLAN_COST);
                videoStreaming = new VideoStreaming(personalPlan);
                break;
        }
        return videoStreaming;
    }

    public PodcastStreaming addPlanForPodcastStreaming(String planType) {
        PodcastStreaming podcastStreaming = null;
        switch (planType) {
            case FREE:
                Plan freePlan = new FreePlan(DURATION_IN_MONTHS_FREE_PLAN, FREE_PLAN_COST);
                podcastStreaming = new PodcastStreaming(freePlan);
                break;
            case PERSONAL:
                Plan personalPlan = new PersonalPlan(DURATION_IN_MONTHS_PERSONAL_PLAN, PODCAST_STREAM_PERSONAL_PLAN_COST);
                podcastStreaming = new PodcastStreaming(personalPlan);
                break;
            case PREMIUM:
                Plan premiumPlan = new PremiumPlan(DURATION_IN_MONTHS_PREMIUM_PLAN, PODCAST_STREAM_PREMIUM_PLAN_COST);
                podcastStreaming = new PodcastStreaming(premiumPlan);
                break;
        }
        return podcastStreaming;
    }
}
