package in.ptanksali.votingapp.votingapp.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_TABLE")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private int id;
	private String user_ka_naam;
	
	@JsonIgnore
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private Collection<Vote> votes = new ArrayList<Vote>();
	
	public Collection<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Collection<Vote> votes) {
		this.votes = votes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_ka_naam() {
		return user_ka_naam;
	}
	public void setUser_ka_naam(String username) {
		this.user_ka_naam = username;
	}
	
}
