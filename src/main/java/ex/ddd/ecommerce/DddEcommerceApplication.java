package ex.ddd.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("ex.ddd.*")
@Configuration
public class DddEcommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DddEcommerceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start");

		System.out.println("END");
	}

}
