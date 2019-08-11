package in.ptanksali.votingapp.votingapp.dao.polls;

import java.util.List;

import in.ptanksali.votingapp.votingapp.models.*;
public interface PollsDAO {
	List<Poll> get();
	Poll get(int id);
	void save(Poll poll);
}
