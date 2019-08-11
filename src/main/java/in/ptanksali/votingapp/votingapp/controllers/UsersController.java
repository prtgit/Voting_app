package in.ptanksali.votingapp.votingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ptanksali.votingapp.votingapp.models.User;
import in.ptanksali.votingapp.votingapp.services.UsersService;

@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/users")
	public List<User> getUsers(){
		return usersService.get();
	}
	
	@RequestMapping(value="/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		return usersService.get(id);
	}
	
	@PostMapping(value="/users")
	public void save(@RequestBody User user) {
		usersService.save(user);
	}
	

}
