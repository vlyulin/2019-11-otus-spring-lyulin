package ru.otus.spring.library.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableFeignClients(basePackages = "ru.otus.spring.library.docker.feign")
public class LibrarySpringHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringHystrixApplication.class, args);
	}

}
