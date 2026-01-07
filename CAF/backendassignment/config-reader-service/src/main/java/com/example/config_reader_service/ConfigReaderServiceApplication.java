package com.example.config_reader_service;

import com.example.config_reader_service.service.ConfigLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigReaderServiceApplication implements CommandLineRunner {

	@Autowired
	private ConfigLoaderService configLoaderService;

	public static void main(String[] args) {
		SpringApplication.run(ConfigReaderServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configLoaderService.loadConfig("config.txt");
		System.out.println("Config file loaded successfully!");
	}
}
