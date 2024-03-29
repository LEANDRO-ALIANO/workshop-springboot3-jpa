package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/users")
/**
 * estou informando que é um controlador rest
 */
public class UserResourse {
	@Autowired
	private UserService service;
	@GetMapping
 public ResponseEntity<List<User>> findAll(){
	 List<User> list = service.findAll();
	 return ResponseEntity.ok().body(list);
 }
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj= service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
