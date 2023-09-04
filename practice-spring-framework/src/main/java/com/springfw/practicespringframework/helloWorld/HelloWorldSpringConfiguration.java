package com.springfw.practicespringframework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {};

record Address(String city, String state) {};

@Configuration
public class HelloWorldSpringConfiguration {

	@Bean
	@Primary
	public String name() {
		return "Lemuel";
	}
	
	
	@Bean
	@Primary
	public int age() {
		return 29;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Lemuel Benitez", 29, new Address("Baker st", "London"));
		
		return person;
	}
	
	@Bean
	public Person person2() {
		var person = new Person(name(), age(), address());
		
		return person;
	}
	
	@Bean
	public Person person3(String name, int age, Address address) {
		var person = new Person(name, age, address);
		
		return person;
	}
	
	@Bean
	public Person person4(@Qualifier("address3Q")Address address) {
		var person = new Person(name(), age(), address);
		
		return person;
	}
	
	@Bean
	@Primary
	public Address address() {
		var address = new Address("Chicago", "Illinois");
		
		return address;
	}
	
	@Bean(name = "address2")
	public Address homeaddress() {
		var address = new Address("Baker st", "London");
		
		return address;
	}
	
	@Bean
	@Qualifier("address3Q")
	public Address address3() {
		var address = new Address("Eiffel Tower", "France");
		
		return address;
	}

}
