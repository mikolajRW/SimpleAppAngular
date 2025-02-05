package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(
			RouteLocatorBuilder builder,
			@Value("${car.url}") String carUrl,
			@Value("${driver.url}") String driverUrl,
			@Value("${gateway.host}") String host
	) {
		return builder
				.routes()
				.route("drivers", route -> route
						.host(host)
						.and()
						.path(
								"/api/drivers/{uuid}",
								"/api/drivers"
						)
						.uri(driverUrl))
				.route("cars", route -> route
						.host(host)
						.and()
						.path(
								"/api/cars",
								"/api/cars/{uuid}",
								"/api/drivers/{uuid}/cars"
						)
						.uri(carUrl)).build();



	}
}
