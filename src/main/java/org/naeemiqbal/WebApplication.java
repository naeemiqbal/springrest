package org.naeemiqbal;

import java.util.Date;

import org.naeemiqbal.db.store.Store;
import org.naeemiqbal.db.store.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@ComponentScan
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	/*
    //@Profile("demo")
    @Bean
    CommandLineRunner initDatabase(StoreRepository repository) {
    	String d="NMI" + new Date();
        return args -> {
            repository.save(new Store(d,d,d,1000));
        };
    }
    */
}
