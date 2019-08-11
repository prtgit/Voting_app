package in.ptanksali.votingapp.votingapp.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Poll {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;
	private String pollName;
	
	@JsonIgnore
	@OneToMany(mappedBy="poll", cascade = CascadeType.ALL)
	private Collection<Topic> topics = new ArrayList<Topic>();
	
	@JsonIgnore
	@OneToMany(mappedBy="poll", cascade = CascadeType.ALL)
	private Collection<Vote> votes = new ArrayList<Vote>();
	
	public Collection<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
	public Collection<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Collection<Topic> topics) {
		this.topics = topics;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPollName() {
		return pollName;
	}
	public void setPollName(String pollName) {
		this.pollName = pollName;
	}
	

}
