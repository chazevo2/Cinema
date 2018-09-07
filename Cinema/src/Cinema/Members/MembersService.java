package Cinema.Members;

import java.util.ArrayList;

public interface MembersService {

	boolean login(Members m);

	void addMembers(Members m);

	void delMembers(String mid);

	void editPwd(Members m);
	
	void editPoint(Members m, int sign);

	Members getMembers(String mid);

	ArrayList<String> getId(Members m);
	
	int age(String mid);

	ArrayList<Members> getAll();

}
