package mx.poc.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocCorsApplication.class, args);
	}

}
