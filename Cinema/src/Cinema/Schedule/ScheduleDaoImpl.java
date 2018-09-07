package Cinema.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class ScheduleDaoImpl implements ScheduleDao {
	private DBConnect db;
	private Connection conn;

	public ScheduleDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Schedule s) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Schedule values(seq_sche_no.nextval,?,to_date(?, 'yy/mm/dd'),?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getMno());
			pstmt.setString(2, s.getMday());
			pstmt.setString(3, s.getMtime());
			pstmt.setInt(4, s.getSprice());
			pstmt.setInt(5, s.getScrno());
			pstmt.setInt(6, s.getEx_seat());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void delete(int sno) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from Schedule where sno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Schedule s) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Schedule set mtime=? where sno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getMtime());
			pstmt.setInt(2, s.getSno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void updateSeat(int sno, int sign) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql;
		if(sign == 1)
			sql = "update Schedule set ex_seat=ex_seat+1 where sno=?";
		else
			sql = "update Schedule set ex_seat=ex_seat-1 where sno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public Schedule select(int sno) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select sno, s.mno, mname, to_char(mday, 'yy/mm/dd'), mtime, sprice, scrno, ex_seat from Schedule s, Movie m where s.mno = m.mno and sno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Schedule(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
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
	public int selectScr(Schedule s) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		int cnt = 0;
		String sql = "select scrno from Schedule s, Movie m where s.mno=m.mno and scrno=? "
				+ "and mday=to_date(?, 'yy/mm/dd')" + "and ((substr(?, 1, 2)*60 + substr(?, 4, 5) "
				+ "between substr(mtime, 1, 2)*60 + substr(mtime, 4, 5) "
				+ "and substr(mtime, 1, 2)*60 + substr(mtime, 4, 5) + (select runtime from movie where mno=?)) "
				+ "or (substr(?, 1, 2)*60 + substr(?, 4, 5) + runtime "
				+ "between substr(mtime, 1, 2)*60 + substr(mtime, 4, 5) "
				+ "and substr(mtime, 1, 2)*60 + substr(mtime, 4, 5) + runtime))";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getScrno());
			pstmt.setString(2, s.getMday());
			pstmt.setString(3, s.getMtime());
			pstmt.setString(4, s.getMtime());
			pstmt.setInt(5, s.getMno());
			pstmt.setString(6, s.getMtime());
			pstmt.setString(7, s.getMtime());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt++;
			}
			if (cnt > 0) {
				return cnt;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
		return -1;
	}

	@Override
	public ArrayList<Schedule> selectByMname(String mname) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		String sql = "select sno, s.mno, mname, to_char(mday, 'yy/mm/dd'), mtime, sprice, scrno, ex_seat from Schedule s, Movie m where s.mno = m.mno and mname like '%" + mname + "%'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Schedule(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
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
	public ArrayList<Schedule> selectByToday() {
		// TODO Auto-generated method stub
		String Today = new java.text.SimpleDateFormat("MMdd").format(new java.util.Date());
		ResultSet rs;
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		conn = db.getConnection();
		String sql = "select sno, s.mno, mname, to_char(mday, 'yy/mm/dd'), mtime, sprice, scrno, ex_seat from Schedule s, Movie m where s.mno = m.mno and to_char(mday, 'MMDD')>=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Today);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Schedule(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
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
	public ArrayList<Schedule> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		conn = db.getConnection();
		String sql = "select sno, s.mno, mname, to_char(mday, 'yy/mm/dd'), mtime, sprice, scrno, ex_seat from Schedule s, Movie m where s.mno = m.mno";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Schedule(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
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
