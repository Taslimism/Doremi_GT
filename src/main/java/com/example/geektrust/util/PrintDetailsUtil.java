package com.example.geektrust.util;

import com.example.geektrust.streaming.MusicStreaming;
import com.example.geektrust.streaming.PodcastStreaming;
import com.example.geektrust.streaming.Streaming;
import com.example.geektrust.streaming.VideoStreaming;
import com.example.geektrust.topup.TopUp;
import com.example.geektrust.user.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PrintDetailsUtil {
    private int DAYS_TO_INCLUDE_FOR_NON_PREMIUM_PLAN = 20;
    private final int DAYS_TO_INCLUDE_IN_PREMIUM_PLAN = 80;
    private static final int INSTRUCTION_TYPE_NAME_INDEX = 0;
    private static final int INSTRUCTION_TYPE_VALUE_INDEX = 1;
    private static final int PLAN_TYPE_INDEX = 2;
    private static final int NO_OF_MONTHS_INDEX = 2;
    private static final String START_SUBSCRIPTION = "START_SUBSCRIPTION";
    private static final String ADD_SUBSCRIPTION = "ADD_SUBSCRIPTION";
    private static final String ADD_TOPUP = "ADD_TOPUP";
    private static final String PRINT_RENEWAL_DETAILS = "PRINT_RENEWAL_DETAILS";
    private static final String MUSIC = "MUSIC";
    private static final String VIDEO = "VIDEO";
    private static final String PODCAST = "PODCAST";

    public void printResults(User user, String dateString) {
        List<Streaming> streamingList = user.getStreamingServicesList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        int cost = 0;
        for (Streaming streaming : streamingList) {
            if (streaming instanceof MusicStreaming) {
                LocalDate newDate = date.plusDays(DAYS_TO_INCLUDE_FOR_NON_PREMIUM_PLAN);
                String newDateStr = newDate.format(formatter);
                System.out.println("RENEWAL_REMINDER MUSIC " + newDateStr);
            } else if (streaming instanceof VideoStreaming) {
                LocalDate newDate = date.plusDays(DAYS_TO_INCLUDE_IN_PREMIUM_PLAN);
                String newDateStr = newDate.format(formatter);
                System.out.println("RENEWAL_REMINDER VIDEO " + newDateStr);
            } else if (streaming instanceof PodcastStreaming) {
                LocalDate newDate = date.plusDays(DAYS_TO_INCLUDE_FOR_NON_PREMIUM_PLAN);
                String newDateStr = newDate.format(formatter);
                System.out.println("RENEWAL_REMINDER PODCAST " + newDateStr);
            }
            cost += streaming.getPlan().getCost();
        }
        TopUp topUp = streamingList.get(0).getTopUp();
        if (topUp != null) {
            cost += topUp.getCost() * topUp.getDurationInMonths();
        }
        System.out.println("RENEWAL_AMOUNT " + cost);
    }

    public void buildSolution(List<String> instructionList) {
        String dateString = "";
        AddSubscriptionUtil addSubscriptionUtil = new AddSubscriptionUtil();
        AddTopUpUtil addTopUpUtil = new AddTopUpUtil();
        PrintDetailsUtil printDetailsUtil = new PrintDetailsUtil();
        List<Streaming> streamingServiceListForAUser = new ArrayList<>();
        User user = new User(streamingServiceListForAUser);
        boolean isDateInvalid = false;

        for (String instruction : instructionList) {
            String[] instructionArray = instruction.split(" ");
            String instructionType = instructionArray[INSTRUCTION_TYPE_NAME_INDEX];
            if (instructionType.equals(START_SUBSCRIPTION)) {
                dateString = instructionArray[INSTRUCTION_TYPE_VALUE_INDEX].trim();
            }

            switch (instructionType) {
                case START_SUBSCRIPTION:
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate.parse(dateString, formatter);
                    } catch (Exception e) {
                        isDateInvalid = true;
                        System.out.println("INVALID_DATE");
                    }
                    break;
                case ADD_SUBSCRIPTION:
                    String streamingType = instructionArray[INSTRUCTION_TYPE_VALUE_INDEX];
                    String planType = instructionArray[PLAN_TYPE_INDEX];
                    switch (streamingType) {
                        case MUSIC:
                            MusicStreaming musicStreaming = addSubscriptionUtil.addPlanForMusicStreaming(planType);
                            user.addStreamingPlatform(musicStreaming);
                            break;
                        case VIDEO:
                            VideoStreaming videoStreaming = addSubscriptionUtil.addPlanForVideoStreaming(planType);
                            user.addStreamingPlatform(videoStreaming);
                            break;
                        case PODCAST:
                            PodcastStreaming podcastStreaming = addSubscriptionUtil.addPlanForPodcastStreaming(planType);
                            user.addStreamingPlatform(podcastStreaming);
                            break;
                    }
                    break;
                case ADD_TOPUP:
                    String topUpType = instructionArray[INSTRUCTION_TYPE_VALUE_INDEX];
                    int numberOfMonths = Integer.parseInt(instructionArray[NO_OF_MONTHS_INDEX]);
                    addTopUpUtil.addTopUpType(topUpType, user, numberOfMonths);
                    break;
                case PRINT_RENEWAL_DETAILS:
                    printDetailsUtil.printResults(user, dateString);
                    break;
            }
        }

    }
}
