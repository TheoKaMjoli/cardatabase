package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;


@JsonIgnoreProperties(
		{	"hibernateLazyInitializer", 
			"hanlder"}
		)
@Entity
public class Owner {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerrid;
	
	private String firstName;
	private String lastname;
	
	
	public Owner() {
		
		
	}


	public Owner(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	//DATABASE....................................
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") 
	@JsonIgnore
	private List<Car> car;


	public List<Car> getCar() {
		return car;
	}


	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	
	//creating a joint table for the many-to-many relational table
	
		@ManyToMany(cascade = CascadeType.MERGE)
		@JoinTable(name = "car_owner", 
		joinColumns =  {@JoinColumn(name = "ownerrid" )}, 
		inverseJoinColumns = {@JoinColumn(name = "id" )})
		private Set<Car> cars = new HashSet<Car>(0);


		public Set<Car> getCars() {
			return cars;
		}


		public void setCars(Set<Car> cars) {
			this.cars = cars;
		}
		
	
	
	
	
	
	

}































