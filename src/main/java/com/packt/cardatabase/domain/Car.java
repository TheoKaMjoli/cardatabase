package com.packt.cardatabase.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String brand;
	private String model;
	private String color;
	private String registrationNumber;
	private int year;
	private int price;
	
	
	public Car() {
		
	}
	
	
	public Car(String brand, String model, String color, String registrationNumber, int year, int price, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registrationNumber = registrationNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
	


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	//DATABASE...............................

	@ManyToOne(fetch = FetchType.LAZY) // In our case, the lazy strategy means that when the owner is fetched from the database, all the cars associated with the owner will be fetched when needed.
	@JoinColumn(name = "owner") // it will create a column that will join with the embaddable class
	private Owner owner;
	
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	//defining many-to-many relationship 
	//In a many-tomany relationship, it is recommended that you use Set instead of List with Hibernate:
	
	@ManyToMany(mappedBy = "cars")
	private Set<Owner> owners;


	public Set<Owner> getOwners() {
		return owners;
	}


	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


























