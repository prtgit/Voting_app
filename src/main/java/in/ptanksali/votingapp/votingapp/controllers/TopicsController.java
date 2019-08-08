package in.ptanksali.votingapp.votingapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ptanksali.votingapp.votingapp.services.*;
import in.ptanksali.votingapp.votingapp.models.*;

@RestController
public class TopicsController {
	@Autowired
	private TopicsService topicsService;
	
	@RequestMapping(value="/polls/{id}/topics")
	public List<Topics> getTopics(@PathVariable("id") int pollId){
		return topicsService.get(pollId);
	}
	
	@PostMapping(value = "/polls/{id}/topics")
	public void addTopic(@RequestBody Topics topic, @PathVariable(name = "id") int id) {
		topicsService.save(topic, id);
	}
	
	@PutMapping(value = "/polls/{id}/topics/{topic_id}")
	public void voteForTopic(@PathVariable("id") int pollId, @PathVariable("topic_id") int topicId) {
		topicsService.vote(topicId);
	}

}
