package Cinema.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class TicketDaoImpl implements TicketDao {
	private DBConnect db;
	private Connection conn;

	public TicketDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Ticket t) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Ticket values(seq_ticket_no.nextval,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t.getMid());
			pstmt.setInt(2, t.getMno());
			pstmt.setInt(3, t.getTprice());
			pstmt.setInt(4, t.getSno());
			pstmt.setString(5, t.getSeatno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Ticket t) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Ticket set seatno=? where tno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, t.getTno());
			pstmt.setString(1, t.getSeatno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void delete(int tno) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from Ticket where tno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public Ticket select(int tno) {
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select tno, mid, t.mno, mname, tprice, t.sno, to_char(mday, 'yy/mm/dd')||' '||mtime, scrno, seatno from Ticket t, Movie m, Schedule s where t.mno=m.mno and t.sno=s.sno and tno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Ticket> selectBySno(int sno) {
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		String sql = "select tno, mid, t.mno, mname, tprice, t.sno,  to_char(mday, 'yy/mm/dd')||' '||mtime, scrno, seatno from Ticket t, Movie m, Schedule s where t.mno=m.mno and t.sno=s.sno and s.sno=? order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return null;
	}

	@Override
	public ArrayList<Ticket> selectByMid(String mid) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		String sql = "select tno, mid, t.mno, mname, tprice, t.sno,  to_char(mday, 'yy/mm/dd')||' '||mtime, scrno, seatno from Ticket t, Movie m, Schedule s where t.mno=m.mno and t.sno=s.sno and mid=? order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disConn();
		return null;
	}

	@Override
	public ArrayList<Ticket> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<Ticket> list = new ArrayList<Ticket>();
		String sql = "select tno, mid, t.mno, mname, tprice, t.sno,  to_char(mday, 'yy/mm/dd')||' '||mtime, scrno, seatno from Ticket t, Movie m, Schedule s where t.mno=m.mno and t.sno=s.sno order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Ticket(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
			}
			if (list.size() > 0) {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.disConn();
		return null;
	}
}
