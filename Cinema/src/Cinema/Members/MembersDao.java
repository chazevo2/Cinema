package Cinema.Members;

import java.util.ArrayList;

public interface MembersDao {
	void insert(Members m); 

	void delete(String mid);

	void update(Members m);

	Members select(String mid);

	ArrayList<String> selectByInfo(Members m);
	
	int age(String mid);

	ArrayList<Members> selectAll();
}
