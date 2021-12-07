package com.example.poc;

import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.poc"})
public class PocServerApplication {
	public static Logger logger = LoggerFactory.getLogger("poc-server");

	@Bean
	public AutoConfiguredOpenTelemetrySdk autoConfiguredOpenTelemetrySdk() {
		return AutoConfiguredOpenTelemetrySdk.initialize();
	}

	public static void main(String[] args) {
		SpringApplication.run(PocServerApplication.class, args);
	}
}
