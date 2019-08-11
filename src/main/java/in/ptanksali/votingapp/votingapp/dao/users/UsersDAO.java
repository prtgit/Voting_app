package in.ptanksali.votingapp.votingapp.dao.users;

import java.util.List;

import in.ptanksali.votingapp.votingapp.models.User;

public interface UsersDAO {
	List<User> get();
	User get(int id);
	void save(User user);
}
