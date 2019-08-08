package in.ptanksali.votingapp.votingapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ptanksali.votingapp.votingapp.dao.topics.TopicsDAO;
import in.ptanksali.votingapp.votingapp.models.*;

@Service
public class TopicsService {
	
	@Autowired
	private TopicsDAO topicsDAO;
	
	@Transactional
	public List<Topics> get(int pollId){
		return topicsDAO.get(pollId);
	}
	
	@Transactional
	public void save(Topics topic, int pollId) {
		topicsDAO.save(topic, pollId);
	}
	
	@Transactional
	public void vote(int id) {
		topicsDAO.vote(id);
	}

}
