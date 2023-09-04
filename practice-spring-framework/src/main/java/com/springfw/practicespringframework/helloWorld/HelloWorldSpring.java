package com.springfw.practicespringframework.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldSpring {

	public static void main(String[] args) {
		//Launch spring context
		//Configure the things we want spring framework to manage
		//@Configuration can be used
		//@Bean - used to annotate method as a bean
		try(var context =
				new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class)){
//var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);
		//Retrieved and managed Beans by Spring, using method or given name
		System.out.println(context.getBean("name"));
		
		System.out.println(context.getBean("age"));
		
		System.out.println(context.getBean("person"));
		
		System.out.println(context.getBean("address2"));
		
		System.out.println(context.getBean("person4"));

		
		System.out.println(context.getBean(Address.class)); 
		// @Primary used to set a version of address as primary
		// @Qualifier("give-name") wires a Bean


        Arrays.stream(context.getBeanDefinitionNames())
              .forEach(System.out::println); //List all "Beans"
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
