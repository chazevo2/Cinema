package Cinema.Screen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class ScreenDaoImpl implements ScreenDao {
	private DBConnect db;
	private Connection conn;

	public ScreenDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Screen scr) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Screen values(seq_screen_no.nextval,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scr.getLine());
			pstmt.setInt(2, scr.getSeat());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Screen scr) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Screen set line=?, seat=? where scrno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scr.getLine());
			pstmt.setInt(2, scr.getSeat());
			pstmt.setInt(3, scr.getScrno());
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
		String sql = "delete from Screen where scrno=?";
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
	public Screen select(int scrno) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select * from Screen where scrno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, scrno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Screen(rs.getInt(1), rs.getInt(2), rs.getInt(3));
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
	public ArrayList<Screen> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<Screen> list = new ArrayList<Screen>();
		String sql = "select * from Screen";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Screen(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
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
