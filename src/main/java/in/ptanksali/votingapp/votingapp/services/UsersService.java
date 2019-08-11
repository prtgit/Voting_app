package in.ptanksali.votingapp.votingapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ptanksali.votingapp.votingapp.dao.users.UsersDAO;
import in.ptanksali.votingapp.votingapp.models.User;

@Service
public class UsersService {
	@Autowired
	private UsersDAO usersDAO;
	
	@Transactional
	public List<User> get(){
		return usersDAO.get();
	}
	
	@Transactional
	public User get(int id) {
		return usersDAO.get(id);
	}
	
	@Transactional
	public void save(User user) {
		usersDAO.save(user);
	}

}
