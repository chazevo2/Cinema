package Cinema.Ticket;

import java.util.ArrayList;

public interface TicketService {
	void addTicket(Ticket t);
	
	void delTicket(int tno);
	
	void editSeatno(Ticket t);

	Ticket getTicket(int tno);
	
	ArrayList<Ticket> getBySno(int sno);

	ArrayList<Ticket> getByMid(String mid);
	
	ArrayList<Ticket> getAll();
}

