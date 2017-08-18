package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.dao.CarDao;

@SpringBootApplication
public class StarterKitJpaStarterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StarterKitJpaStarterApplication.class, args);
	}
}
