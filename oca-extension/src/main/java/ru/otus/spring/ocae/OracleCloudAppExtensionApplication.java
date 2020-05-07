package ru.otus.spring.ocae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients
@SpringBootApplication
public class OracleCloudAppExtensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(OracleCloudAppExtensionApplication.class, args);
	}

}
// (exclude = {DataSourceAutoConfiguration.class })
