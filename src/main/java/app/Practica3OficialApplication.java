package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@ComponentScan(basePackages = {"service"}) 
@EntityScan(basePackages = {"entities"}) 
@EnableJpaRepositories("repositories")
public class Practica3OficialApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practica3OficialApplication.class, args);
	}

}
