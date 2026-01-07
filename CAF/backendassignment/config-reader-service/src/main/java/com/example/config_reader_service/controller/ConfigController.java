package com.example.config_reader_service.controller;

import com.example.config_reader_service.service.ConfigLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigController {

    @Autowired
    private ConfigLoaderService configLoaderService;

    @GetMapping("/config")
    public Map<String, Object> getConfig(
            @RequestParam String section) {

        return configLoaderService.getSection(section);
    }
}
