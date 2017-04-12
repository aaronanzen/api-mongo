package mx.com.anzen.genericbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class NameApp {

	public static void main(String[] args) {
		SpringApplication.run(NameApp.class, args);
	}
}
