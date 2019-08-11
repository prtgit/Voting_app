package in.ptanksali.votingapp.votingapp.dao.polls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ptanksali.votingapp.votingapp.models.*;


@Repository
public class PollsDAOImpl implements PollsDAO{
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Poll> get() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Poll");
		List<Poll> polls = (List<Poll>)query.list();
		return polls;
	}

	@Override
	public Poll get(int id) {
		Session session = entityManager.unwrap(Session.class);
		Poll p = (Poll)session.get(Poll.class, id);
		return p;
	}

	@Override
	public void save(Poll poll) {
		Session session = entityManager.unwrap(Session.class);
		session.save(poll);
		//session.getTransaction().commit();
	}

}
