package in.ptanksali.votingapp.votingapp.dao.polls;

import java.util.List;

import in.ptanksali.votingapp.votingapp.models.*;
public interface PollsDAO {
	List<Polls> get();
	Polls get(int id);
	void save(Polls poll);
}
