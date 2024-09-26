package com.Eureka.ProxyServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class ProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyServerApplication.class, args);
	}

}
