package com.rest.user;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	UserDao udo = new UserDao();
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		return udo.getAllUsers();		
	}
	
	@RequestMapping("/addUser")
	public int addUser(@RequestParam(value="id") int id,
			@RequestParam(value="name") String name,
			@RequestParam(value="profession") String profession){
			User pUser = new User(id, name, profession);
			int returnValue = udo.addUser(pUser);	
			return returnValue;
	}
	
	@RequestMapping("/updateUser")
	public int updateUser(@RequestParam(value="id") int id,
			@RequestParam(value="name") String name,
			@RequestParam(value="profession") String profession){
			User pUser = new User(id, name, profession);
			int returnValue = udo.updateUser(pUser);	
			return returnValue;
	}

}
