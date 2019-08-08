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
public class Polls {
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;
	private String pollName;
	
	@JsonIgnore
	@OneToMany(mappedBy="poll", cascade = CascadeType.ALL)
	private Collection<Topics> topics = new ArrayList<Topics>();
	public Collection<Topics> getTopics() {
		return topics;
	}
	public void setTopics(Collection<Topics> topics) {
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
