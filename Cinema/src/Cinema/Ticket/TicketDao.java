package Cinema.Ticket;

import java.util.ArrayList;

public interface TicketDao {
	void insert(Ticket t);

	void update(Ticket t);

	void delete(int tno);

	Ticket select(int tno);

	ArrayList<Ticket> selectBySno(int sno);

	ArrayList<Ticket> selectByMid(String mid);

	ArrayList<Ticket> selectAll();

}
