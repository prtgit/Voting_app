package in.ptanksali.votingapp.votingapp.dao.topics;

import java.util.List;
import in.ptanksali.votingapp.votingapp.models.*;

public interface TopicsDAO {
	
	
	List<Topics> get(int pollId);
	void save(Topics topic, int pollId);
	void vote(int id);
	
	

}
