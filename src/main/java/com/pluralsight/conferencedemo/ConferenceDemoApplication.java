package com.pluralsight.conferencedemo;

import com.pluralsight.conferencedemo.controllers.SessionControllers;
import com.pluralsight.conferencedemo.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ConferenceDemoApplication {

	private static SessionControllers sessionStaticController;
	@Autowired
	private SessionControllers sessionController;

	@PostConstruct
	private void init(){
		sessionStaticController = this.sessionController;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConferenceDemoApplication.class, args);
		createSession(new Session());
	}

	public static void createSession(Session session){
		session.setSession_name("conference");
		session.setSession_length(150);
		session.setSession_description("this is a first test ");
		sessionStaticController.create(session);
	}

}
