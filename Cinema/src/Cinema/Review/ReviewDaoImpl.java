package Cinema.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Cinema.DBConnect;

public class ReviewDaoImpl implements ReviewDao {
	private DBConnect db;
	private Connection conn;

	public ReviewDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Review r) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "insert into Review values (seq_review_no.nextval, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getMno());
			pstmt.setString(2, r.getMid());
			pstmt.setInt(3, r.getScore());
			pstmt.setString(4, r.getMemo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void update(Review r) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "update Review set score=?, memo=? where rno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getScore());
			pstmt.setString(2, r.getMemo());
			pstmt.setInt(3, r.getRno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		conn = db.getConnection();
		String sql = "delete from Review where rno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.disConn();
		}
	}

	@Override
	public Review select(int rno) {
		// TODO Auto-generated method stub
		ResultSet rs;
		conn = db.getConnection();
		String sql = "select rno, r.mno, mname, mid, score, memo from Review r, Movie m where r.mno=m.mno and rno=?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
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
	public ArrayList<Review> selectByMid(String mid) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Review> list = new ArrayList<Review>();
		conn = db.getConnection();
		String sql = "select rno, r.mno, mname, mid, score, memo from Review r, Movie m where r.mno=m.mno and mid=? order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
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
	public ArrayList<Review> selectByMname(String mname) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Review> list = new ArrayList<Review>();
		conn = db.getConnection();
		String sql = "select rno, r.mno, mname, mid, score, memo from Review r, Movie m where r.mno=m.mno and mname like '%" + mname + "%' order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
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
	public ArrayList<Review> selectAvgScore() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Review> list = new ArrayList<Review>();
		conn = db.getConnection();
		String sql = "select mname, count(mname), round(avg(score)) from Review r, Movie m where r.mno=m.mno group by mname order by 3 desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(0, 0, rs.getString(1), rs.getInt(2)+"", rs.getInt(3), ""));
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
	public ArrayList<Review> selectByScore(int score) {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Review> list = new ArrayList<Review>();
		conn = db.getConnection();
		String sql = "select rno, r.mno, mname, mid, score, memo from Review r, Movie m where r.mno=m.mno and score >= ? order by 5 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, score);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
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
	public ArrayList<Review> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs;
		ArrayList<Review> list = new ArrayList<Review>();
		conn = db.getConnection();
		String sql = "select rno, r.mno, mname, mid, score, memo from Review r, Movie m where r.mno=m.mno order by 1 asc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
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

}
