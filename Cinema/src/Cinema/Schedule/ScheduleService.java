package Cinema.Schedule;

import java.util.ArrayList;

public interface ScheduleService {
	void addSchedule(Schedule s);

	void delSchedule(int sno);

	void editTime(Schedule s);

	void editSeat(int no, int sign);
	
	int getScr(Schedule s);

	Schedule getSchedule(int sno);

	ArrayList<Schedule> getByMname(String mname);

	ArrayList<Schedule> getByToday();

	ArrayList<Schedule> selectAll();
}
