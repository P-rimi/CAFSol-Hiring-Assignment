package com.example.priceservice.controller;

import com.example.priceservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class PriceController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/price")
    public String getPrice(
            @RequestParam String skuid,
            @RequestParam String time) {

        LocalTime queryTime = LocalTime.parse(time);

        Integer price = offerService.getPrice(skuid, queryTime);

        if (price == null) {
            return "NOT SET";
        }

        return String.valueOf(price);
    }
}
