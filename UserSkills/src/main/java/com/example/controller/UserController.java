package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/alluser")
	public List<User> fetchUserList() {
		return userService.fetchUserList();
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable("id") int id) {
		return userService.findById(id);
	}

	@GetMapping("/skill/{skillId}")
	public List<User> getAllUserByskillId(@PathVariable("skillId") int id) {
		return userService.findAllByskillId(id);
	}

	@GetMapping("/skills/{skillName}")
	public List<User> getAllUsersBySkillSkillName(@PathVariable("skillName") String skillName) {
		return userService.findAllByskillName(skillName);
	}

	@PostMapping("/userList")
	public List<User> insertListUser(@RequestBody List<User> user) {
		return userService.insertListUser(user);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable("id") int id) {
		return userService.updateUser(user, id);
	}
	
	@GetMapping("/pagindAndShortingUsers/{pageNumber}/{pageSize}")
	public Page<User> userPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
		return userService.getUserPagination(pageNumber,pageSize);
	}
	
}
