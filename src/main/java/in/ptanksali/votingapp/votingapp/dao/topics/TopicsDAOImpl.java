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
	public List<Topic> get(int pollId) {
		Session session = entityManager.unwrap(Session.class);
		Poll p = (Poll)session.get(Poll.class,pollId);
		List<Topic> topics = (List<Topic>)p.getTopics();
		return topics;
	}

	@Override
	public void save(Topic topic, int pollId) {
		Session session = entityManager.unwrap(Session.class);
		Poll p = (Poll)session.get(Poll.class,pollId);
		topic.setPoll(p);
		session.save(topic);
		
	}

	/*
	 * @Override public void vote(int id) { Session session =
	 * entityManager.unwrap(Session.class); Topic t =
	 * (Topic)session.get(Topic.class, id); t.setVotes(t.getVotes()+1);
	 * session.update(t); }
	 */

	

}
