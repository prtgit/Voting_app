package in.ptanksali.votingapp.votingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ptanksali.votingapp.votingapp.dao.votes.VotesDAO;
import in.ptanksali.votingapp.votingapp.models.Vote;
import in.ptanksali.votingapp.votingapp.services.VotesService;

@RestController
public class VotesController {
	
	@Autowired
	private VotesService votesService;
	
	@RequestMapping(value = "/votesByUser/{id}")
	public List<Vote> getVotesByUser(@PathVariable("id") int userId){
		return votesService.getVotesByUser(userId);
	}
	
	@RequestMapping(value = "/votesByPoll/{id}")
	public List<Vote> getVotesByPoll(@PathVariable("id") int pollId){
		return votesService.getVotesByPoll(pollId);
	}
	
	@RequestMapping(value = "/votesByTopic/{id}")
	public List<Vote> getVotesByTopic(@PathVariable("id") int topicId){
		return votesService.getVotesByTopic(topicId);
	}
	
	@PostMapping("/votes")
	public void vote(@RequestParam("userId") int userId, @RequestParam("topicId") int topicId) {
		votesService.vote(new Vote(), userId, topicId);
	}
	

}
