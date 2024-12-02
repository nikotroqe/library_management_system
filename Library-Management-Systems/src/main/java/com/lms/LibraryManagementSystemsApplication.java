package com.lms;

import com.lms.model.User;
import com.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryManagementSystemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemsApplication.class, args);
	}

}
