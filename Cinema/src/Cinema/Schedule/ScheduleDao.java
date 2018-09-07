package Cinema.Schedule;

import java.util.ArrayList;

public interface ScheduleDao {
	void insert(Schedule s);

	void delete(int sno);
	
	void update(Schedule s);

	void updateSeat(int sno, int sign);

	Schedule select(int sno);
	
	int selectScr(Schedule s);

	ArrayList<Schedule> selectByMname(String mname);

	ArrayList<Schedule> selectByToday();

	ArrayList<Schedule> selectAll();
}
