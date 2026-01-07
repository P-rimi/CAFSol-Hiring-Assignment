package com.example.priceservice.model;

import java.time.LocalTime;

public class Offer {

    private String skuId;
    private LocalTime startTime;
    private LocalTime endTime;
    private int price;

    public Offer(String skuId, LocalTime startTime, LocalTime endTime, int price) {
        this.skuId = skuId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getSkuId() {
        return skuId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getPrice() {
        return price;
    }
}
