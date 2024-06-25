package ScreeningHumanity.SearchServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SearchServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServerApplication.class, args);
	}

}
