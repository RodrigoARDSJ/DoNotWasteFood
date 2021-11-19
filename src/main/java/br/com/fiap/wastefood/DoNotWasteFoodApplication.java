package br.com.fiap.wastefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DoNotWasteFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoNotWasteFoodApplication.class, args);
	}

}
