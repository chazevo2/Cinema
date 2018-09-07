package Cinema.Members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class MembersDaoImpl implements MembersDao {
	private DBConnect db;
	private Connection conn;
	
	public MembersDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Members m) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Members values(?,?,?,to_date(?,'yy/mm/dd'),?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUname());
			pstmt.setString(2, m.getMid());
			pstmt.setString(3, m.getPwd());
			pstmt.setString(4, m.getBirth());
			pstmt.setInt(5, 100);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void delete(String mid) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from Members where mid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Members m) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Members set pwd=? where mid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}
	
	@Override
	public void updatePoint(Members m, int sign) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql;
		if(sign == 1)
			sql = "update Members set point=point+? where mid=?";
		else
			sql = "update Members set point=point-? where mid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getPoint());
			pstmt.setString(2, m.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public Members select(String mid) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select uname, mid, pwd, to_char(birth,'yy/mm/dd'), point from Members where mid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
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
	public ArrayList<String> selectByInfo(Members m) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select mid from Members where uname=? and birth=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUname());
			pstmt.setString(2, m.getBirth());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
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
	public int age(String mid) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select floor(months_between(sysdate, birth)/12) from Members where mid=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
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
	public ArrayList<Members> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Members> list = new ArrayList<Members>();
		conn = db.getConnection();
		String sql = "select uname, mid, pwd, to_char(birth,'yy/mm/dd'), point from Members";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
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
