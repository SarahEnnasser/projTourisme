package org.trsm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.trsm.entities.User;
import org.trsm.repository.UserRepository;



@SpringBootApplication
public class ProjTourismeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjTourismeApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(ProjTourismeApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatabase(UserRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new User("Sarah", "Ennasser","Software Engineer")));
			log.info("Preloading " + repository.save(new User("Serena", "Wiliams","Tenis player")));
		};
	}

}
