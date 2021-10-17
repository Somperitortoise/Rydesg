package com.ryde.sg.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryde.sg.entity.UserEntity;
import com.ryde.sg.exception.CreateUserException;
import com.ryde.sg.model.ResponseModel;
import com.ryde.sg.model.User;
import com.ryde.sg.serviceinterface.UserInterface;



@RestController
@RequestMapping("api/ryde/user")
public class UserController {
	
	@Autowired
	UserInterface userInterface;
	
	@PostMapping("/addUser")
	public ResponseEntity<ResponseModel> addUser(@Valid @RequestBody User req) throws CreateUserException{
		try {
			return ResponseEntity.ok(userInterface.addUser(req));
		} catch (CreateUserException e) {
			throw new CreateUserException("error in create user", e); 
		}
		
	}
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserEntity>> getAllUser() throws Exception{
		try {
			return ResponseEntity.ok(userInterface.findAllUser());
		} catch (Exception e) {
			throw new Exception("error in get all user", e); 
		}
	}
	
	@PostMapping("/deleteUser")
	public ResponseEntity<ResponseModel> deleteUser(@RequestBody User req) throws Exception{
		try {
			return ResponseEntity.ok(userInterface.deleteUser(req));
		} catch (CreateUserException e) {
			throw new CreateUserException("error in edit user", e); 
		}
		
	}
	
	@PostMapping("/editUser")
	public ResponseEntity<ResponseModel> editUser(@RequestBody User req) throws Exception{
		try {
			return ResponseEntity.ok(userInterface.editUser(req));
		} catch (CreateUserException e) {
			throw new CreateUserException("error in edit user", e); 
		}
		
	}

}
