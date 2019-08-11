package in.ptanksali.votingapp.votingapp.dao.votes;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.ptanksali.votingapp.votingapp.models.Poll;
import in.ptanksali.votingapp.votingapp.models.Topic;
import in.ptanksali.votingapp.votingapp.models.User;
import in.ptanksali.votingapp.votingapp.models.Vote;

@Repository
public class VotesDAOImpl implements VotesDAO{
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Vote> getVotesByUser(int userId) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Vote where user.id = ?1");
		query.setParameter(1, userId);
		List<Vote> votes = (List<Vote>) query.list();
		return votes;
	}

	@Override
	public List<Vote> getVotesByTopic(int topicId) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Vote where topic.id = ?1");
		query.setParameter(1, topicId);
		List<Vote> votes = (List<Vote>) query.list();
		return votes;
	}

	@Override
	public List<Vote> getVotesByPoll(int pollId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Vote where poll.id = ?1");
		query.setParameter(1, pollId);
		List<Vote> votes = (List<Vote>) query.list();
		return votes;
	}

	@Override
	public void save(Vote vote, int userId, int topicId) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, userId);
		Topic topic = session.get(Topic.class, topicId);
		Query query = session.createQuery("select T.poll from Topic as T where T.topic_id = ?1 ");
		query.setParameter(1, topicId);
		Poll poll = (Poll)query.getSingleResult();
		vote.setUser(user);
		vote.setTopic(topic);
		vote.setPoll(poll);
		
		session.save(vote);
		
		
		
		
		
	}

}
