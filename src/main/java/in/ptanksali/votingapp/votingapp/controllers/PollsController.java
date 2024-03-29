package in.ptanksali.votingapp.votingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ptanksali.votingapp.votingapp.models.Poll;
import in.ptanksali.votingapp.votingapp.services.*;

@RestController
public class PollsController {
	
	@Autowired
	private PollsService pollsService;
	
	@RequestMapping(value="/polls")
	public List<Poll> getAllPolls(){
		System.out.println("Prax Tanksali");
		List<Poll> polls = pollsService.get();
		return polls;
	}
	
	@RequestMapping(value="/polls/{id}", produces = {"application/JSON"})
	public Poll getPoll(@PathVariable("id") int id) {
		return pollsService.get(id);
	}
	
	@PostMapping(value="/polls")
	public void createPoll(@RequestBody Poll poll){
		pollsService.save(poll);
	}
	

}
