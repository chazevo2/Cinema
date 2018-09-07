package Cinema.Ticket;

import java.util.ArrayList;

public class TicketServiceImpl implements TicketService {

	private TicketDao dao;

	public TicketServiceImpl(TicketDao dao) {
		this.dao = dao;
	}

	@Override
	public void addTicket(Ticket t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	@Override
	public void editSeatno(Ticket t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	@Override
	public void delTicket(int tno) {
		// TODO Auto-generated method stub
		dao.delete(tno);
	}

	@Override
	public Ticket getTicket(int tno) {
		// TODO Auto-generated method stub
		return dao.select(tno);
	}

	@Override
	public ArrayList<Ticket> getBySno(int sno) {
		// TODO Auto-generated method stub
		return dao.selectBySno(sno);
	}

	@Override
	public ArrayList<Ticket> getByMid(String mid) {
		// TODO Auto-generated method stub
		return dao.selectByMid(mid);
	}

	@Override
	public ArrayList<Ticket> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
}
