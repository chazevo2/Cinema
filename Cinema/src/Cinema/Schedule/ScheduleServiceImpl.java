package Cinema.Schedule;

import java.util.ArrayList;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDao dao;

	public ScheduleServiceImpl(ScheduleDao dao) {
		this.dao = dao;
	}

	@Override
	public void addSchedule(Schedule s) {
		// TODO Auto-generated method stub
		dao.insert(s);
	}

	@Override
	public void delSchedule(int sno) {
		// TODO Auto-generated method stub
		dao.delete(sno);
	}

	@Override
	public void editTime(Schedule s) {
		// TODO Auto-generated method stub
		dao.update(s);
	}

	@Override
	public void editSeat(int no, int sign) {
		// TODO Auto-generated method stub
		dao.updateSeat(no, sign);
	}

	@Override
	public Schedule getSchedule(int sno) {
		// TODO Auto-generated method stub
		return dao.select(sno);
	}

	@Override
	public ArrayList<Schedule> getByMname(String mname) {
		// TODO Auto-generated method stub
		return dao.selectByMname(mname);
	}

	@Override
	public ArrayList<Schedule> getByToday() {
		// TODO Auto-generated method stub
		return dao.selectByToday();
	}

	@Override
	public ArrayList<Schedule> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public int getScr(Schedule s) {
		// TODO Auto-generated method stub
		return dao.selectScr(s);
	}

}
