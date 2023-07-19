package com.example.tinqin.zoostorestorage.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.tinqin.zoostorestorage")
@EntityScan(basePackages = "com.example.tinqin.zoostorestorage.persistence.entity")
@EnableJpaRepositories(basePackages = "com.example.tinqin.zoostorestorage.persistence.repository")

public class ZooStoreStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooStoreStorageApplication.class, args);
	}

}
