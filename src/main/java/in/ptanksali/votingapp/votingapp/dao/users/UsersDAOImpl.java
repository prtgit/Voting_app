package in.ptanksali.votingapp.votingapp.dao.users;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ptanksali.votingapp.votingapp.models.User;

@Repository
public class UsersDAOImpl implements UsersDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from User");
		List<User> users = (List<User>)query.list();
		return users;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
		
	}

}
