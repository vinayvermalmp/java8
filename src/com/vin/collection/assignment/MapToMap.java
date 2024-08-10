package com.vin.collection.assignment;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MapToMap {
    public static void main(String[] args) {
        Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channelName, numSubscribers
        Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
        Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers
        // channel -> number of subscribers (K, V1)
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher (K, V2)
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        channelToSubscribers.forEach((channel, noOfSubscriber) -> {
            String publicher = channelToPublisher.get(channel);
            if (publisherToSubscribers.containsKey(publicher)) {
                int currentNoOfSubscriber = publisherToSubscribers.get(publicher);
                int newValue = currentNoOfSubscriber+noOfSubscriber;
                publisherToSubscribers.put(publicher, newValue);
            } else {
                publisherToSubscribers.put(publicher, noOfSubscriber);
            }

        });
        publisherToSubscribers.forEach((publisher, noOfSubscriber ) -> {
            System.out.println("publisher: "+publisher+"; numSubscribers:"+noOfSubscriber);
        });

        int maxSub = Collections.max(publisherToSubscribers.values());
        int minSub = Collections.min(publisherToSubscribers.values());
        publisherToSubscribers.forEach((pub, noSub) -> {
            if (noSub == maxSub ) {
                System.out.println("Publisher with most subscribers: " + pub + " " + maxSub);
            } else if (noSub == minSub) {
                System.out.println("Publisher with fewest subscribers: " + pub + " " + minSub);
            }
        });


    }
}
