package com.packt.cardatabase;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@ComponentScan({"com.cardatabase.web"})
public class CardatabaseApplication {
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired 
	private OwnerRepository ownerRepository;
	
	
	//private static final Logger logger = (Logger) LoggerFactory.getLogger(CardatabaseApplication.class);
			
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			
			//Add owner objects and save these to db.
			Owner owner1 = new Owner("Theo", "Nukwayo");
			Owner owner2 = new Owner("Natasha", "Maka");
		//	Owner owner3 = new Owner("Monde", "Nukwayo");
			
			
			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			//ownerRepository.save(owner3);
			
			//Add objects that link owners
			Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
			Car car2 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
			Car car3 = new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2);
		//	Car car4 = new Car("Toyota", "Corolla", "black", "AAR-3440", 2017, 31000, owner3);
			
			//saving demo data to database
			carRepository.save(car1);
			carRepository.save(car2);
			carRepository.save(car3);
			
			
		};
		
	}

}
