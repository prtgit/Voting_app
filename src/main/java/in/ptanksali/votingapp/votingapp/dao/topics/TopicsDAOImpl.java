package in.ptanksali.votingapp.votingapp.dao.topics;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ptanksali.votingapp.votingapp.models.*;

@Repository
public class TopicsDAOImpl implements TopicsDAO{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Topics> get(int pollId) {
		Session session = entityManager.unwrap(Session.class);
		Polls p = (Polls)session.get(Polls.class,pollId);
		List<Topics> topics = (List<Topics>)p.getTopics();
		return topics;
	}

	@Override
	public void save(Topics topic, int pollId) {
		Session session = entityManager.unwrap(Session.class);
		Polls p = (Polls)session.get(Polls.class,pollId);
		topic.setPoll(p);
		session.save(topic);
		
	}

	@Override
	public void vote(int id) {
		Session session = entityManager.unwrap(Session.class);
		Topics t = (Topics)session.get(Topics.class, id);
		t.setVotes(t.getVotes()+1);
		session.update(t);
	}

	

}
