package com.example.priceservice.service;

import com.example.priceservice.model.Offer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.*;

@Service
public class OfferService {


    private final Map<String, List<Offer>> offerMap = new HashMap<>();

    @PostConstruct
    public void loadOffers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("offers.tsv"))) {

            String line;
            boolean isHeader = true;

            while ((line = reader.readLine()) != null) {


                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] parts = line.split("\\|");

                String skuId = parts[0];
                LocalTime startTime = LocalTime.parse(parts[1]);
                LocalTime endTime = LocalTime.parse(parts[2]);
                int price = Integer.parseInt(parts[3]);

                Offer offer = new Offer(skuId, startTime, endTime, price);

                offerMap
                        .computeIfAbsent(skuId, k -> new ArrayList<>())
                        .add(offer);
            }

            System.out.println("Offers loaded successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getPrice(String skuId, LocalTime time) {

        List<Offer> offers = offerMap.get(skuId);

        if (offers == null) {
            return null;
        }

        Offer bestOffer = null;

        for (Offer offer : offers) {
            if (!time.isBefore(offer.getStartTime())
                    && !time.isAfter(offer.getEndTime())) {

                if (bestOffer == null ||
                        offer.getStartTime().isAfter(bestOffer.getStartTime())) {
                    bestOffer = offer;
                }
            }
        }

        return bestOffer != null ? bestOffer.getPrice() : null;
    }

}
