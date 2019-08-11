package in.ptanksali.votingapp.votingapp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ptanksali.votingapp.votingapp.dao.users.UsersDAO;
import in.ptanksali.votingapp.votingapp.dao.votes.VotesDAO;
import in.ptanksali.votingapp.votingapp.models.Vote;

@Service
public class VotesService {
	@Autowired
	private VotesDAO votesDAO;
	
	@Transactional
	public List<Vote> getVotesByUser(int userId){
		return votesDAO.getVotesByUser(userId);
	}
	
	@Transactional
	public List<Vote> getVotesByPoll(int pollId){
		return votesDAO.getVotesByPoll(pollId);
	}
	
	@Transactional
	public List<Vote> getVotesByTopic(int topicId){
		return votesDAO.getVotesByTopic(topicId);
	}
	
	@Transactional
	public void vote(Vote vote, int userId, int topicId) {
		votesDAO.save(vote, userId, topicId);
	}
}
