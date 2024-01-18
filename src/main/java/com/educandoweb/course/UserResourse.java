package com.educandoweb.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController
@RequestMapping(value="/users")
/**
 * estou informando que é um controlador rest
 */
public class UserResourse {
	@GetMapping
 public ResponseEntity<User> findAll(){
	 User u = new User(1L, "maria", "maria@gmail.com","999999","1234");
	 return ResponseEntity.ok().body(u);
 }
}
