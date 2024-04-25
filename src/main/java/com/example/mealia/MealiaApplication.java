package com.example.mealia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(repositoryBaseClass = RefreshableCRUDRepositoryImpl.class)
@SpringBootApplication
public class MealiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MealiaApplication.class, args);
	}

}
