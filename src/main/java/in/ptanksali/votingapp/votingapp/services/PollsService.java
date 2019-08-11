package in.ptanksali.votingapp.votingapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ptanksali.votingapp.votingapp.dao.polls.PollsDAO;
import in.ptanksali.votingapp.votingapp.models.*;

@Service
public class PollsService {
	
	
	@Autowired
	private PollsDAO pollsDAO;

	@Transactional
	public List<Poll> get() {
		return pollsDAO.get();
	}
	
	@Transactional
	public Poll get(int id) {
		return pollsDAO.get(id);
	}
	
	@Transactional
	public void save(Poll poll) {
		pollsDAO.save(poll);
	}
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */


}
