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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Topic {
  
  @Id@GeneratedValue(strategy=GenerationType.IDENTITY)  
  @Column(unique=true, nullable=false)
  private int topic_id;
  
  private String topicName; 
  
  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="id")
  private Poll poll;
  
  @JsonIgnore
  @OneToMany(mappedBy="topic", cascade = CascadeType.ALL)
  private Collection<Vote> votes = new ArrayList<Vote>();
  
  public Collection<Vote> getVotes() {
	  return votes;
  }

  public void setVotes(Collection<Vote> votes) {
	  this.votes = votes;
  }

public int getTopic_id() { return topic_id; }
  
  public void setTopic_id(int topic_id) { this.topic_id = topic_id; }
  
  public String getTopicName() { return topicName; }
  
  public void setTopicName(String topicName) { this.topicName = topicName; }
  
  public Poll getPoll() { return poll; }
  
  public void setPoll(Poll poll) { this.poll = poll; } }
 

/*
 * @Entity public class Topic{
 * 
 * @EmbeddedId private EmbeddedId primaryKey;
 * 
 * private String topicName;
 * 
 * 
 * }
 */
