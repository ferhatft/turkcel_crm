package com.turkcell.pair6.customerservice;

import com.turkcell.annotations.EnableSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableSecurity
public class CustomerserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerserviceApplication.class, args);
	}


}
