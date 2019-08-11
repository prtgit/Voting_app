package in.ptanksali.votingapp.votingapp.dao.votes;
import java.util.List;

import in.ptanksali.votingapp.votingapp.models.*;
public interface VotesDAO {
	List<Vote> getVotesByUser(int userId);
	List<Vote> getVotesByTopic(int topicId);
	List<Vote> getVotesByPoll(int pollId);
	public void save(Vote vote, int userId, int topicId);

}
