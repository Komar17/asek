package Asek.Asekapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import Asek.Asekapi.Controller.UserController;
//@ComponentScan(basePackageClasses = UserController.class)
//@SpringBootApplication
@SpringBootApplication(scanBasePackages={"Asek.Asekapi","Asek.Asekapi.service","Asek.Asekapi.Controller","Asek.Asekapi.repository"})
public class AsekApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsekApiApplication.class, args);
	}
}
