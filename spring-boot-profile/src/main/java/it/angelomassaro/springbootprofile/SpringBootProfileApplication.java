package it.angelomassaro.springbootprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "it.angelomassaro.springbootprofile", "it.angelomassaro.springbootprofile.rest", "it.angelomassaro.aspect"} )
public class SpringBootProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfileApplication.class, args);
	}

}
